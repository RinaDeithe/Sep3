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
public final class ItemTypeServiceGrpc {

  private ItemTypeServiceGrpc() {}

  public static final String SERVICE_NAME = "GRPC.proto.ItemTypeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemTypeCreationRequest,
      GRPC.proto.File.ItemProto> METHOD_CREATE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemTypeCreationRequest, GRPC.proto.File.ItemProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ItemTypeService", "Create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeCreationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemTypeSearchRequest,
      GRPC.proto.File.ItemProto> METHOD_READ =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemTypeSearchRequest, GRPC.proto.File.ItemProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ItemTypeService", "Read"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.emptyParams,
      GRPC.proto.File.ItemTypeListProto> METHOD_READ_ALL =
      io.grpc.MethodDescriptor.<GRPC.proto.File.emptyParams, GRPC.proto.File.ItemTypeListProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ItemTypeService", "ReadAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.emptyParams.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeListProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemTypeSearchRequest,
      GRPC.proto.File.ItemProto> METHOD_DELETE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemTypeSearchRequest, GRPC.proto.File.ItemProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.ItemTypeService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ItemTypeServiceStub newStub(io.grpc.Channel channel) {
    return new ItemTypeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ItemTypeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ItemTypeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ItemTypeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ItemTypeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ItemTypeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(GRPC.proto.File.ItemTypeCreationRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    /**
     */
    public void read(GRPC.proto.File.ItemTypeSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ, responseObserver);
    }

    /**
     */
    public void readAll(GRPC.proto.File.emptyParams request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeListProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ALL, responseObserver);
    }

    /**
     */
    public void delete(GRPC.proto.File.ItemTypeSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemTypeCreationRequest,
                GRPC.proto.File.ItemProto>(
                  this, METHODID_CREATE)))
          .addMethod(
            METHOD_READ,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemTypeSearchRequest,
                GRPC.proto.File.ItemProto>(
                  this, METHODID_READ)))
          .addMethod(
            METHOD_READ_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.emptyParams,
                GRPC.proto.File.ItemTypeListProto>(
                  this, METHODID_READ_ALL)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemTypeSearchRequest,
                GRPC.proto.File.ItemProto>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class ItemTypeServiceStub extends io.grpc.stub.AbstractStub<ItemTypeServiceStub> {
    private ItemTypeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ItemTypeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ItemTypeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ItemTypeServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(GRPC.proto.File.ItemTypeCreationRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(GRPC.proto.File.ItemTypeSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAll(GRPC.proto.File.emptyParams request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeListProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(GRPC.proto.File.ItemTypeSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ItemTypeServiceBlockingStub extends io.grpc.stub.AbstractStub<ItemTypeServiceBlockingStub> {
    private ItemTypeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ItemTypeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ItemTypeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ItemTypeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPC.proto.File.ItemProto create(GRPC.proto.File.ItemTypeCreationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemProto read(GRPC.proto.File.ItemTypeSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemTypeListProto readAll(GRPC.proto.File.emptyParams request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ALL, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemProto delete(GRPC.proto.File.ItemTypeSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ItemTypeServiceFutureStub extends io.grpc.stub.AbstractStub<ItemTypeServiceFutureStub> {
    private ItemTypeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ItemTypeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ItemTypeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ItemTypeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemProto> create(
        GRPC.proto.File.ItemTypeCreationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemProto> read(
        GRPC.proto.File.ItemTypeSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemTypeListProto> readAll(
        GRPC.proto.File.emptyParams request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemProto> delete(
        GRPC.proto.File.ItemTypeSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_READ = 1;
  private static final int METHODID_READ_ALL = 2;
  private static final int METHODID_DELETE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ItemTypeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ItemTypeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((GRPC.proto.File.ItemTypeCreationRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((GRPC.proto.File.ItemTypeSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto>) responseObserver);
          break;
        case METHODID_READ_ALL:
          serviceImpl.readAll((GRPC.proto.File.emptyParams) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeListProto>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((GRPC.proto.File.ItemTypeSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto>) responseObserver);
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

  private static final class ItemTypeServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPC.proto.File.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ItemTypeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ItemTypeServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE)
              .addMethod(METHOD_READ)
              .addMethod(METHOD_READ_ALL)
              .addMethod(METHOD_DELETE)
              .build();
        }
      }
    }
    return result;
  }
}
