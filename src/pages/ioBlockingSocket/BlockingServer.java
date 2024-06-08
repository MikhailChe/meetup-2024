package pages.ioBlockingSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

import lombok.extern.log4j.Log4j2;
import utils.Executors;

@SuppressWarnings("ALL")
@Log4j2
public class BlockingServer {
    static final ExecutorService THREAD_POOL = Executors.namedFixed("blocking-server", 2);

    public static void main(String... args) {
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            while (true) {
                final Socket socket = serverSocket.accept();
                THREAD_POOL.execute(
                        () -> {
                            byte[] data = null;
                            try {
                                data = socket.getInputStream().readAllBytes();
                                var result = process(data);
                                socket.getOutputStream().write(result);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] process(byte[] bytes) {
        return "Hello, world".getBytes(StandardCharsets.UTF_8);
    }
}
