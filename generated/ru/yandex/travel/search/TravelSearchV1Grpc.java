package ru.yandex.travel.search;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: github.com/mikhailche/meetup-2024/proto/search.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TravelSearchV1Grpc {

  private TravelSearchV1Grpc() {}

  public static final String SERVICE_NAME = "search.TravelSearchV1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.yandex.travel.search.SearchRequestV1,
      ru.yandex.travel.search.SearchResponseV1> getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Search",
      requestType = ru.yandex.travel.search.SearchRequestV1.class,
      responseType = ru.yandex.travel.search.SearchResponseV1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.yandex.travel.search.SearchRequestV1,
      ru.yandex.travel.search.SearchResponseV1> getSearchMethod() {
    io.grpc.MethodDescriptor<ru.yandex.travel.search.SearchRequestV1, ru.yandex.travel.search.SearchResponseV1> getSearchMethod;
    if ((getSearchMethod = TravelSearchV1Grpc.getSearchMethod) == null) {
      synchronized (TravelSearchV1Grpc.class) {
        if ((getSearchMethod = TravelSearchV1Grpc.getSearchMethod) == null) {
          TravelSearchV1Grpc.getSearchMethod = getSearchMethod =
              io.grpc.MethodDescriptor.<ru.yandex.travel.search.SearchRequestV1, ru.yandex.travel.search.SearchResponseV1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Search"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.yandex.travel.search.SearchRequestV1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.yandex.travel.search.SearchResponseV1.getDefaultInstance()))
              .setSchemaDescriptor(new TravelSearchV1MethodDescriptorSupplier("Search"))
              .build();
        }
      }
    }
    return getSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ru.yandex.travel.search.DummyRequestV1,
      ru.yandex.travel.search.DummyResponseV1> getDummyCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DummyCall",
      requestType = ru.yandex.travel.search.DummyRequestV1.class,
      responseType = ru.yandex.travel.search.DummyResponseV1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.yandex.travel.search.DummyRequestV1,
      ru.yandex.travel.search.DummyResponseV1> getDummyCallMethod() {
    io.grpc.MethodDescriptor<ru.yandex.travel.search.DummyRequestV1, ru.yandex.travel.search.DummyResponseV1> getDummyCallMethod;
    if ((getDummyCallMethod = TravelSearchV1Grpc.getDummyCallMethod) == null) {
      synchronized (TravelSearchV1Grpc.class) {
        if ((getDummyCallMethod = TravelSearchV1Grpc.getDummyCallMethod) == null) {
          TravelSearchV1Grpc.getDummyCallMethod = getDummyCallMethod =
              io.grpc.MethodDescriptor.<ru.yandex.travel.search.DummyRequestV1, ru.yandex.travel.search.DummyResponseV1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DummyCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.yandex.travel.search.DummyRequestV1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.yandex.travel.search.DummyResponseV1.getDefaultInstance()))
              .setSchemaDescriptor(new TravelSearchV1MethodDescriptorSupplier("DummyCall"))
              .build();
        }
      }
    }
    return getDummyCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TravelSearchV1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelSearchV1Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelSearchV1Stub>() {
        @Override
        public TravelSearchV1Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelSearchV1Stub(channel, callOptions);
        }
      };
    return TravelSearchV1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TravelSearchV1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelSearchV1BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelSearchV1BlockingStub>() {
        @Override
        public TravelSearchV1BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelSearchV1BlockingStub(channel, callOptions);
        }
      };
    return TravelSearchV1BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TravelSearchV1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelSearchV1FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelSearchV1FutureStub>() {
        @Override
        public TravelSearchV1FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelSearchV1FutureStub(channel, callOptions);
        }
      };
    return TravelSearchV1FutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TravelSearchV1ImplBase implements io.grpc.BindableService {

    /**
     */
    public void search(ru.yandex.travel.search.SearchRequestV1 request,
        io.grpc.stub.StreamObserver<ru.yandex.travel.search.SearchResponseV1> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /**
     */
    public void dummyCall(ru.yandex.travel.search.DummyRequestV1 request,
        io.grpc.stub.StreamObserver<ru.yandex.travel.search.DummyResponseV1> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDummyCallMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ru.yandex.travel.search.SearchRequestV1,
                ru.yandex.travel.search.SearchResponseV1>(
                  this, METHODID_SEARCH)))
          .addMethod(
            getDummyCallMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ru.yandex.travel.search.DummyRequestV1,
                ru.yandex.travel.search.DummyResponseV1>(
                  this, METHODID_DUMMY_CALL)))
          .build();
    }
  }

  /**
   */
  public static final class TravelSearchV1Stub extends io.grpc.stub.AbstractAsyncStub<TravelSearchV1Stub> {
    private TravelSearchV1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TravelSearchV1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelSearchV1Stub(channel, callOptions);
    }

    /**
     */
    public void search(ru.yandex.travel.search.SearchRequestV1 request,
        io.grpc.stub.StreamObserver<ru.yandex.travel.search.SearchResponseV1> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dummyCall(ru.yandex.travel.search.DummyRequestV1 request,
        io.grpc.stub.StreamObserver<ru.yandex.travel.search.DummyResponseV1> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDummyCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TravelSearchV1BlockingStub extends io.grpc.stub.AbstractBlockingStub<TravelSearchV1BlockingStub> {
    private TravelSearchV1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TravelSearchV1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelSearchV1BlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.yandex.travel.search.SearchResponseV1 search(ru.yandex.travel.search.SearchRequestV1 request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public ru.yandex.travel.search.DummyResponseV1 dummyCall(ru.yandex.travel.search.DummyRequestV1 request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDummyCallMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TravelSearchV1FutureStub extends io.grpc.stub.AbstractFutureStub<TravelSearchV1FutureStub> {
    private TravelSearchV1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TravelSearchV1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelSearchV1FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.yandex.travel.search.SearchResponseV1> search(
        ru.yandex.travel.search.SearchRequestV1 request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.yandex.travel.search.DummyResponseV1> dummyCall(
        ru.yandex.travel.search.DummyRequestV1 request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDummyCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;
  private static final int METHODID_DUMMY_CALL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TravelSearchV1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TravelSearchV1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH:
          serviceImpl.search((ru.yandex.travel.search.SearchRequestV1) request,
              (io.grpc.stub.StreamObserver<ru.yandex.travel.search.SearchResponseV1>) responseObserver);
          break;
        case METHODID_DUMMY_CALL:
          serviceImpl.dummyCall((ru.yandex.travel.search.DummyRequestV1) request,
              (io.grpc.stub.StreamObserver<ru.yandex.travel.search.DummyResponseV1>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TravelSearchV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TravelSearchV1BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.yandex.travel.search.Search.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TravelSearchV1");
    }
  }

  private static final class TravelSearchV1FileDescriptorSupplier
      extends TravelSearchV1BaseDescriptorSupplier {
    TravelSearchV1FileDescriptorSupplier() {}
  }

  private static final class TravelSearchV1MethodDescriptorSupplier
      extends TravelSearchV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TravelSearchV1MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TravelSearchV1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TravelSearchV1FileDescriptorSupplier())
              .addMethod(getSearchMethod())
              .addMethod(getDummyCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
