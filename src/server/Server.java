package server;


import interceptors.LoggingServerInterceptor;
import io.grpc.BindableService;
import io.grpc.protobuf.services.ProtoReflectionService;
import lombok.extern.slf4j.Slf4j;
import utils.Executors;

@Slf4j
public class Server {
    private final int port;
    private final BindableService svc;

    public Server(int port, BindableService svc) {
        this.port = port;
        this.svc = svc;
    }


    public io.grpc.Server withDirectExecutor() {
        return baseServerBuilder()
                .directExecutor()
                .build();
    }


    public io.grpc.Server withDefaultExecutor() {
        return baseServerBuilder()
                .build();
    }


    public io.grpc.Server withFixedThreadPool(int threads) {
        return baseServerBuilder()
                .executor(Executors.namedFixed("server-fixed", threads))
                .build();
    }


    private io.grpc.ServerBuilder<?> baseServerBuilder() {
        return io.grpc.ServerBuilder.forPort(port)
                .addService(ProtoReflectionService.newInstance())
                .addService(svc)
                .intercept(new LoggingServerInterceptor("SERVER"));
    }
}
