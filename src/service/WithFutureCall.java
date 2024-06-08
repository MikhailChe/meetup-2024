package service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import utils.Executors;

import ru.yandex.travel.search.DummyRequestV1;
import ru.yandex.travel.search.DummyResponseV1;
import ru.yandex.travel.search.SearchRequestV1;
import ru.yandex.travel.search.SearchResponseV1;
import ru.yandex.travel.search.TravelSearchV1Grpc;

@Slf4j
public class WithFutureCall extends TravelSearchV1Grpc.TravelSearchV1ImplBase {
    private final AtomicInteger rspID;
    private final TravelSearchV1Grpc.TravelSearchV1FutureStub stub;

    public WithFutureCall(TravelSearchV1Grpc.TravelSearchV1FutureStub stub) {
        this.rspID = new AtomicInteger();
        this.stub = stub;
    }

    @Override
    public void search(SearchRequestV1 request, StreamObserver<SearchResponseV1> responseObserver) {
        asyncHelper(responseObserver,
                CompletableFuture
                        .runAsync(() -> {
                            log.info("Search on thread {}", Thread.currentThread().getName());
                            log.info("Search is sleeping for {}ms", request.getDelay());
                        }, Executors.namedCached("search-start"))
                        .thenComposeAsync((ignored) -> {
                            log.info("Search is calling dummy using future stub");
                            return convertToCompletableFuture(stub.dummyCall(DummyRequestV1.newBuilder().build()));
                        }, CompletableFuture.delayedExecutor(request.getDelay(), TimeUnit.MILLISECONDS,
                                Executors.namedCached("awaitor")))
                        .thenApplyAsync((dummyResponse) -> {
                            log.info("Search is done");
                            return SearchResponseV1.newBuilder()
                                    .setThreadName(Thread.currentThread().getName())
                                    .setRspID(rspID.incrementAndGet())
                                    .setReqID(request.getReqID())
                                    .build();
                        }, Executors.namedCached("search-done"))
        );
        log.info("Search released thread for netty");
    }

    @Override
    public void dummyCall(DummyRequestV1 request, StreamObserver<DummyResponseV1> responseObserver) {
        asyncHelper(responseObserver, CompletableFuture.supplyAsync(() -> {
            log.info("Dummy on thread {}", Thread.currentThread().getName());
            return DummyResponseV1.newBuilder().build();
        }));
    }

    private <RS> void asyncHelper(StreamObserver<RS> responseObserver, CompletableFuture<RS> fn) {
        fn.whenCompleteAsync((rs, e) -> {
            if (e != null) {
                responseObserver.onError(e);
                return;
            }
            responseObserver.onNext(rs);
            responseObserver.onCompleted();
        });
    }

    private <V> CompletableFuture<V> convertToCompletableFuture(ListenableFuture<V> listenable) {
        var completable = new CompletableFuture<V>();
        listenable.addListener(() -> {
            if (!listenable.isDone()) {
                return;
            }
            try {
                completable.complete(listenable.get());
            } catch (InterruptedException | ExecutionException e) {
                completable.completeExceptionally(e);
            }
        }, Executors.namedCached("completable-listenable"));
        return completable;
    }
}
