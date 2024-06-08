package interceptors;

import javax.annotation.Nullable;

import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingClientInterceptor implements ClientInterceptor {
    private final String interceptorName;

    public LoggingClientInterceptor(String interceptorName) {
        this.interceptorName = interceptorName;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions, Channel next) {
        log.info("[{}] ICEPTOR", interceptorName);
        return new ForwardingClientCall.SimpleForwardingClientCall<>(next.newCall(method,
                callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                log.info("[{}] CC start", interceptorName);
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<>(responseListener) {
                    @Override
                    public void onHeaders(Metadata headers) {
                        log.info("[{}] CCL onHeaders", interceptorName);
                        super.onHeaders(headers);
                    }

                    @Override
                    public void onMessage(RespT message) {
                        log.info("[{}] CCL onMessage", interceptorName);
                        super.onMessage(message);
                    }

                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        log.info("[{}] CCL onClose", interceptorName);
                        super.onClose(status, trailers);
                    }
                }, headers);
            }

            @Override
            public void request(int numMessages) {
                log.info("[{}] CC request", interceptorName);
                super.request(numMessages);
            }

            @Override
            public void sendMessage(ReqT message) {
                log.info("[{}] CC sendMessage", interceptorName);
                super.sendMessage(message);
            }

            @Override
            public void halfClose() {
                log.info("[{}] CC halfClose", interceptorName);
                super.halfClose();
            }


            // Остальное не вызывается в обычном флоу обработки одного сообщения
            @Override
            public void cancel(@Nullable String message, @Nullable Throwable cause) {
                log.info("[{}] CC cancel", interceptorName);
                super.cancel(message, cause);
            }


            @Override
            public void setMessageCompression(boolean enabled) {
                log.info("[{}] CC setMessageCompression", interceptorName);
                super.setMessageCompression(enabled);
            }

            @Override
            public boolean isReady() {
                log.info("[{}] CC isReady", interceptorName);
                return super.isReady();
            }

            @Override
            public Attributes getAttributes() {
                log.info("[{}] CC getAttributes", interceptorName);
                return super.getAttributes();
            }
        };
    }
}
