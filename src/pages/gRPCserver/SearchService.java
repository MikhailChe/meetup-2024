package pages.gRPCserver;

import java.util.concurrent.atomic.AtomicInteger;

import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;

import ru.yandex.travel.search.SearchRequestV1;
import ru.yandex.travel.search.SearchResponseV1;
import ru.yandex.travel.search.TravelSearchV1Grpc.TravelSearchV1ImplBase;

import static utils.Sleep.sleep;

@Log4j2
public class SearchService extends TravelSearchV1ImplBase {
    final AtomicInteger counter = new AtomicInteger();

    @Override
    public void search(SearchRequestV1 request, StreamObserver<SearchResponseV1> responseObserver) {
        final var reqID = request.getReqID();
        final var rspID = counter.incrementAndGet();
        if (request.getDelay() > 0) {
            sleep(request.getDelay());
        }
        responseObserver.onNext(SearchResponseV1.newBuilder()
                .setReqID(reqID)
                .setRspID(rspID)
                .setThreadName(Thread.currentThread().getName())
                .build());
        responseObserver.onCompleted();
    }
}
