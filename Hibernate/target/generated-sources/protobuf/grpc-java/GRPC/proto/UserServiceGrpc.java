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
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "GRPC.proto.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.CreateUserRequest,
      GRPC.proto.File.UserProto> METHOD_CREATE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.CreateUserRequest, GRPC.proto.File.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.UserService", "Create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.CreateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.UserSearchRequest,
      GRPC.proto.File.UserProto> METHOD_READ =
      io.grpc.MethodDescriptor.<GRPC.proto.File.UserSearchRequest, GRPC.proto.File.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.UserService", "Read"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.emptyParams,
      GRPC.proto.File.UserListProto> METHOD_READ_ALL =
      io.grpc.MethodDescriptor.<GRPC.proto.File.emptyParams, GRPC.proto.File.UserListProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.UserService", "ReadAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.emptyParams.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserListProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.UserProto,
      GRPC.proto.File.UserProto> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.UserProto, GRPC.proto.File.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.UserService", "Update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.UserSearchRequest,
      GRPC.proto.File.UserProto> METHOD_DELETE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.UserSearchRequest, GRPC.proto.File.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.UserService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(GRPC.proto.File.CreateUserRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    /**
     */
    public void read(GRPC.proto.File.UserSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ, responseObserver);
    }

    /**
     */
    public void readAll(GRPC.proto.File.emptyParams request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserListProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ALL, responseObserver);
    }

    /**
     */
    public void update(GRPC.proto.File.UserProto request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void delete(GRPC.proto.File.UserSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.CreateUserRequest,
                GRPC.proto.File.UserProto>(
                  this, METHODID_CREATE)))
          .addMethod(
            METHOD_READ,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.UserSearchRequest,
                GRPC.proto.File.UserProto>(
                  this, METHODID_READ)))
          .addMethod(
            METHOD_READ_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.emptyParams,
                GRPC.proto.File.UserListProto>(
                  this, METHODID_READ_ALL)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.UserProto,
                GRPC.proto.File.UserProto>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.UserSearchRequest,
                GRPC.proto.File.UserProto>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(GRPC.proto.File.CreateUserRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(GRPC.proto.File.UserSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAll(GRPC.proto.File.emptyParams request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserListProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(GRPC.proto.File.UserProto request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(GRPC.proto.File.UserSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPC.proto.File.UserProto create(GRPC.proto.File.CreateUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.UserProto read(GRPC.proto.File.UserSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.UserListProto readAll(GRPC.proto.File.emptyParams request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ALL, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.UserProto update(GRPC.proto.File.UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.UserProto delete(GRPC.proto.File.UserSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.UserProto> create(
        GRPC.proto.File.CreateUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.UserProto> read(
        GRPC.proto.File.UserSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.UserListProto> readAll(
        GRPC.proto.File.emptyParams request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.UserProto> update(
        GRPC.proto.File.UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.UserProto> delete(
        GRPC.proto.File.UserSearchRequest request) {
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
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((GRPC.proto.File.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((GRPC.proto.File.UserSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto>) responseObserver);
          break;
        case METHODID_READ_ALL:
          serviceImpl.readAll((GRPC.proto.File.emptyParams) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.UserListProto>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((GRPC.proto.File.UserProto) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((GRPC.proto.File.UserSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto>) responseObserver);
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

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPC.proto.File.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceDescriptorSupplier())
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
