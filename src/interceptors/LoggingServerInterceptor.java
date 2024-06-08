package interceptors;

import io.grpc.Attributes;
import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.SecurityLevel;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingServerInterceptor implements ServerInterceptor {
    private final String interceptorName;

    public LoggingServerInterceptor(String interceptorName) {
        this.interceptorName = interceptorName;
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        log.info("[{}] ICEPTOR", interceptorName, call.getMethodDescriptor().getFullMethodName());
        var interceptedCall = new ForwardingServerCall.SimpleForwardingServerCall<>(call) {
            @Override
            public void request(int numMessages) {
                log.info("[{}] SC request", interceptorName);
//                throw new RuntimeException("on Server Call request");
                super.request(numMessages);
            }

            @Override
            public void sendHeaders(Metadata headers) {
                log.info("[{}] SC sendHeaders", interceptorName);
                super.sendHeaders(headers);
            }

            @Override
            public boolean isReady() {
                log.info("[{}] SC isReady", interceptorName);
                return super.isReady();
            }

            @Override
            public boolean isCancelled() {
                log.info("[{}] SC isCancelled", interceptorName);
                return super.isCancelled();
            }

            @Override
            public void setMessageCompression(boolean enabled) {
                log.info("[{}] SC setMessageCompression", interceptorName);
                super.setMessageCompression(enabled);
            }

            @Override
            public void setCompression(String compressor) {
                log.info("[{}] SC setCompression", interceptorName);
                super.setCompression(compressor);
            }

            @Override
            public Attributes getAttributes() {
                log.info("[{}] SC getAttributes", interceptorName);
                return super.getAttributes();
            }

            @Override
            public String getAuthority() {
                log.info("[{}] SC getAuthority", interceptorName);
                return super.getAuthority();
            }

            @Override
            public SecurityLevel getSecurityLevel() {
                log.info("[{}] SC getSecurityLevel", interceptorName);
                return super.getSecurityLevel();
            }

            @Override
            public void sendMessage(RespT message) {
                log.info("[{}] SC sendMessage", interceptorName);
                super.sendMessage(message);
            }

            @Override
            public void close(Status status, Metadata trailers) {
                log.info("[{}] SC close", interceptorName);
//                throw new RuntimeException("Exception during close");
                super.close(status, trailers);
            }
        };

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<>(
                next.startCall(interceptedCall, headers)) {
            @Override
            public void onMessage(ReqT message) {
                log.info("[{}] SCL onMessage", interceptorName);
                super.onMessage(message);
            }

            @Override
            public void onHalfClose() {
                log.info("[{}] SCL onHalfClose", interceptorName);
//                throw new RuntimeException("On server call listener half-close");
                super.onHalfClose();
            }

            @Override
            public void onComplete() {
                log.info("[{}] SCL onComplete", interceptorName);
                super.onComplete();
            }

            @Override
            public void onReady() {
                log.info("[{}] SCL onReady", interceptorName);
                super.onReady();
            }

            @Override
            public void onCancel() {
                log.info("[{}] SCL onCancel {}",
                        interceptorName, call.getMethodDescriptor().getFullMethodName());
                super.onCancel();
            }
        };
    }
}
