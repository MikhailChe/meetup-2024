package client;

import java.util.concurrent.TimeUnit;

import interceptors.LoggingClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import utils.Executors;

import ru.yandex.travel.search.TravelSearchV1Grpc;

public class Client implements AutoCloseable {

    private final ManagedChannel channel;

    public Client(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .intercept(new LoggingClientInterceptor("CLIENT"))
                .executor(Executors.namedCached("client-channel-executor"))
                .build();
    }

    public TravelSearchV1Grpc.TravelSearchV1BlockingStub blockingStub() {
        return TravelSearchV1Grpc.newBlockingStub(this.channel);
    }

    public TravelSearchV1Grpc.TravelSearchV1FutureStub futureStub() {
        return TravelSearchV1Grpc.newFutureStub(this.channel);
    }

    @Override
    public void close() throws Exception {
        this.channel.shutdownNow();
        this.channel.awaitTermination(1, TimeUnit.MINUTES);
    }
}
