package service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import ru.yandex.travel.search.DummyRequestV1;
import ru.yandex.travel.search.DummyResponseV1;
import ru.yandex.travel.search.SearchRequestV1;
import ru.yandex.travel.search.SearchResponseV1;
import ru.yandex.travel.search.TravelSearchV1Grpc;

import static utils.Sleep.sleep;

@Slf4j
public class WithBlockingCall extends TravelSearchV1Grpc.TravelSearchV1ImplBase {
    private final AtomicInteger rspID;
    private final TravelSearchV1Grpc.TravelSearchV1BlockingStub stub;

    public WithBlockingCall(TravelSearchV1Grpc.TravelSearchV1BlockingStub stub) {
        this.rspID = new AtomicInteger();
        this.stub = stub;
    }

    @Override
    public void search(SearchRequestV1 request, StreamObserver<SearchResponseV1> responseObserver) {
        syncHelper(responseObserver, () -> {
            log.info("Search on thread {}", Thread.currentThread().getName());
            log.info("Search is now sleeping for {}ms", request.getDelay());
            sleep(request.getDelay());
            log.info("Search is now calling dummy directly using BlockingStub");
            stub.dummyCall(DummyRequestV1.newBuilder().build());
            log.info("Search is done");
            return SearchResponseV1.newBuilder()
                    .setThreadName(Thread.currentThread().getName())
                    .setRspID(rspID.incrementAndGet())
                    .setReqID(request.getReqID())
                    .build();

        });
    }

    @Override
    public void dummyCall(DummyRequestV1 request, StreamObserver<DummyResponseV1> responseObserver) {
        syncHelper(responseObserver, () -> {
            log.info("Dummy on thread {}", Thread.currentThread().getName());
            return DummyResponseV1.newBuilder().build();
        });
    }

    private <RS> void syncHelper(StreamObserver<RS> responseObserver, Supplier<RS> fn) {
        try {
            responseObserver.onNext(fn.get());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }
}
