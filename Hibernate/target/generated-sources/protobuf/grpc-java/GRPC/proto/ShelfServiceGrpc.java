package GRPC.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: File.proto")
public final class ShelfServiceGrpc {

  private ShelfServiceGrpc() {}

  public static final String SERVICE_NAME = "GRPC.proto.ShelfService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ShelfCreationRequest,
      GRPC.proto.File.ShelfProto> METHOD_CREATE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ShelfCreationRequest, GRPC.proto.File.ShelfProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ShelfService", "Create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfCreationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ShelfSearchRequest,
      GRPC.proto.File.ShelfProto> METHOD_READ =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ShelfSearchRequest, GRPC.proto.File.ShelfProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ShelfService", "Read"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.emptyParams,
      GRPC.proto.File.ShelvesListProto> METHOD_READ_ALL =
      io.grpc.MethodDescriptor.<GRPC.proto.File.emptyParams, GRPC.proto.File.ShelvesListProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ShelfService", "ReadAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.emptyParams.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelvesListProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ShelfProto,
      GRPC.proto.File.ShelfProto> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ShelfProto, GRPC.proto.File.ShelfProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ShelfService", "Update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ShelfSearchRequest,
      GRPC.proto.File.ShelfProto> METHOD_DELETE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ShelfSearchRequest, GRPC.proto.File.ShelfProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ShelfService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ShelfServiceStub newStub(io.grpc.Channel channel) {
    return new ShelfServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ShelfServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ShelfServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ShelfServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ShelfServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ShelfServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(GRPC.proto.File.ShelfCreationRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    /**
     */
    public void read(GRPC.proto.File.ShelfSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ, responseObserver);
    }

    /**
     */
    public void readAll(GRPC.proto.File.emptyParams request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelvesListProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ALL, responseObserver);
    }

    /**
     */
    public void update(GRPC.proto.File.ShelfProto request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void delete(GRPC.proto.File.ShelfSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ShelfCreationRequest,
                GRPC.proto.File.ShelfProto>(
                  this, METHODID_CREATE)))
          .addMethod(
            METHOD_READ,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ShelfSearchRequest,
                GRPC.proto.File.ShelfProto>(
                  this, METHODID_READ)))
          .addMethod(
            METHOD_READ_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.emptyParams,
                GRPC.proto.File.ShelvesListProto>(
                  this, METHODID_READ_ALL)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ShelfProto,
                GRPC.proto.File.ShelfProto>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ShelfSearchRequest,
                GRPC.proto.File.ShelfProto>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class ShelfServiceStub extends io.grpc.stub.AbstractStub<ShelfServiceStub> {
    private ShelfServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ShelfServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShelfServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ShelfServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(GRPC.proto.File.ShelfCreationRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(GRPC.proto.File.ShelfSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAll(GRPC.proto.File.emptyParams request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelvesListProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(GRPC.proto.File.ShelfProto request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(GRPC.proto.File.ShelfSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ShelfServiceBlockingStub extends io.grpc.stub.AbstractStub<ShelfServiceBlockingStub> {
    private ShelfServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ShelfServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShelfServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ShelfServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPC.proto.File.ShelfProto create(GRPC.proto.File.ShelfCreationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ShelfProto read(GRPC.proto.File.ShelfSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ShelvesListProto readAll(GRPC.proto.File.emptyParams request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ALL, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ShelfProto update(GRPC.proto.File.ShelfProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ShelfProto delete(GRPC.proto.File.ShelfSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ShelfServiceFutureStub extends io.grpc.stub.AbstractStub<ShelfServiceFutureStub> {
    private ShelfServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ShelfServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShelfServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ShelfServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelfProto> create(
        GRPC.proto.File.ShelfCreationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelfProto> read(
        GRPC.proto.File.ShelfSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelvesListProto> readAll(
        GRPC.proto.File.emptyParams request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelfProto> update(
        GRPC.proto.File.ShelfProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelfProto> delete(
        GRPC.proto.File.ShelfSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_READ = 1;
  private static final int METHODID_READ_ALL = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ShelfServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ShelfServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((GRPC.proto.File.ShelfCreationRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((GRPC.proto.File.ShelfSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto>) responseObserver);
          break;
        case METHODID_READ_ALL:
          serviceImpl.readAll((GRPC.proto.File.emptyParams) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelvesListProto>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((GRPC.proto.File.ShelfProto) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((GRPC.proto.File.ShelfSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ShelfServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPC.proto.File.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ShelfServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ShelfServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE)
              .addMethod(METHOD_READ)
              .addMethod(METHOD_READ_ALL)
              .addMethod(METHOD_UPDATE)
              .addMethod(METHOD_DELETE)
              .build();
        }
      }
    }
    return result;
  }
}
