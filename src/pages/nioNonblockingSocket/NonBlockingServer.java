package pages.nioNonblockingSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NonBlockingServer {
    public static void main(String... args) throws IOException {
        new NonBlockingServer().server();
    }

    public void server() throws IOException {
        Selector selector = Selector.open();
        try (ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress("localhost", 9000));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel client = serverSocket.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        try (SocketChannel client = (SocketChannel) selectionKey.channel()) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                            client.read(byteBuffer);
                        }
                    }
                    iterator.remove();
                }
            }
        }
    }
}
