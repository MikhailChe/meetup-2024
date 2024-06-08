package pages.gRPCserver;

import java.io.IOException;

import io.grpc.protobuf.services.ProtoReflectionService;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class GRPCServer {
    final static int port = 8080;

    public static void main(String... args) throws IOException, InterruptedException {
        new GRPCServer().server();
    }

    public void server() throws IOException, InterruptedException {
        final var grpcServer = io.grpc.ServerBuilder.forPort(port)
                .addService(ProtoReflectionService.newInstance())
                .addService(new SearchService())
//                .executor(Executors.newCachedThreadPool(
//                        new ThreadFactoryBuilder().setNameFormat("custom-grpc-%d").build())
//                )
//                .directExecutor()
                .build();
        grpcServer.start();
        log.info("gRPC server started, listening on port {} with config {}", port, grpcServer);
        synchronized (GRPCServer.class) {
            try {
                GRPCServer.class.wait();
            } catch (InterruptedException e) {
                grpcServer.shutdownNow();
                grpcServer.awaitTermination();
                System.out.println("Gracefully shutdown gRPC server");
                throw new RuntimeException(e);
            }
        }
    }
}
