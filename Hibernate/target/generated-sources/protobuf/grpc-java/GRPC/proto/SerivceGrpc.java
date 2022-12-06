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
public final class SerivceGrpc {

  private SerivceGrpc() {}

  public static final String SERVICE_NAME = "GRPC.proto.Serivce";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ShelfSearchRequest,
      GRPC.proto.File.ShelfProto> METHOD_GET_SHELF =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ShelfSearchRequest, GRPC.proto.File.ShelfProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "getShelf"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ShelfProto,
      GRPC.proto.File.ShelfProto> METHOD_UPDATE_SHELF =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ShelfProto, GRPC.proto.File.ShelfProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "UpdateShelf"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelfProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.getAllRequest,
      GRPC.proto.File.ShelvesListProto> METHOD_GET_ALL_SHELVES =
      io.grpc.MethodDescriptor.<GRPC.proto.File.getAllRequest, GRPC.proto.File.ShelvesListProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "getAllShelves"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.getAllRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ShelvesListProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemTypeCreationRequest,
      GRPC.proto.File.ItemTypeProto> METHOD_CREATE_ITEM_TYPE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemTypeCreationRequest, GRPC.proto.File.ItemTypeProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "CreateItemType"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeCreationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemTypeSearchRequest,
      GRPC.proto.File.ItemTypeProto> METHOD_READ_ITEM_TYPE =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemTypeSearchRequest, GRPC.proto.File.ItemTypeProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "ReadItemType"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemTypeProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemCreation,
      GRPC.proto.File.ItemProto> METHOD_CREATE_ITEM =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemCreation, GRPC.proto.File.ItemProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "CreateItem"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemCreation.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemSearchRequest,
      GRPC.proto.File.ItemProto> METHOD_READ_ITEM =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemSearchRequest, GRPC.proto.File.ItemProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "ReadItem"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.ItemSearchRequest,
      GRPC.proto.File.ItemProto> METHOD_DELETE_ITEM =
      io.grpc.MethodDescriptor.<GRPC.proto.File.ItemSearchRequest, GRPC.proto.File.ItemProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "DeleteItem"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemSearchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.ItemProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<GRPC.proto.File.CreateUserRequest,
      GRPC.proto.File.UserProto> METHOD_CREATE_USER =
      io.grpc.MethodDescriptor.<GRPC.proto.File.CreateUserRequest, GRPC.proto.File.UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GRPC.proto.Serivce", "CreateUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.CreateUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              GRPC.proto.File.UserProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SerivceStub newStub(io.grpc.Channel channel) {
    return new SerivceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SerivceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SerivceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SerivceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SerivceFutureStub(channel);
  }

  /**
   */
  public static abstract class SerivceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getShelf(GRPC.proto.File.ShelfSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SHELF, responseObserver);
    }

    /**
     */
    public void updateShelf(GRPC.proto.File.ShelfProto request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_SHELF, responseObserver);
    }

    /**
     */
    public void getAllShelves(GRPC.proto.File.getAllRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelvesListProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_SHELVES, responseObserver);
    }

    /**
     */
    public void createItemType(GRPC.proto.File.ItemTypeCreationRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_ITEM_TYPE, responseObserver);
    }

    /**
     */
    public void readItemType(GRPC.proto.File.ItemTypeSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ITEM_TYPE, responseObserver);
    }

    /**
     */
    public void createItem(GRPC.proto.File.ItemCreation request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_ITEM, responseObserver);
    }

    /**
     */
    public void readItem(GRPC.proto.File.ItemSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_ITEM, responseObserver);
    }

    /**
     */
    public void deleteItem(GRPC.proto.File.ItemSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_ITEM, responseObserver);
    }

    /**
     */
    public void createUser(GRPC.proto.File.CreateUserRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_USER, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_SHELF,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ShelfSearchRequest,
                GRPC.proto.File.ShelfProto>(
                  this, METHODID_GET_SHELF)))
          .addMethod(
            METHOD_UPDATE_SHELF,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ShelfProto,
                GRPC.proto.File.ShelfProto>(
                  this, METHODID_UPDATE_SHELF)))
          .addMethod(
            METHOD_GET_ALL_SHELVES,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.getAllRequest,
                GRPC.proto.File.ShelvesListProto>(
                  this, METHODID_GET_ALL_SHELVES)))
          .addMethod(
            METHOD_CREATE_ITEM_TYPE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemTypeCreationRequest,
                GRPC.proto.File.ItemTypeProto>(
                  this, METHODID_CREATE_ITEM_TYPE)))
          .addMethod(
            METHOD_READ_ITEM_TYPE,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemTypeSearchRequest,
                GRPC.proto.File.ItemTypeProto>(
                  this, METHODID_READ_ITEM_TYPE)))
          .addMethod(
            METHOD_CREATE_ITEM,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemCreation,
                GRPC.proto.File.ItemProto>(
                  this, METHODID_CREATE_ITEM)))
          .addMethod(
            METHOD_READ_ITEM,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemSearchRequest,
                GRPC.proto.File.ItemProto>(
                  this, METHODID_READ_ITEM)))
          .addMethod(
            METHOD_DELETE_ITEM,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.ItemSearchRequest,
                GRPC.proto.File.ItemProto>(
                  this, METHODID_DELETE_ITEM)))
          .addMethod(
            METHOD_CREATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.proto.File.CreateUserRequest,
                GRPC.proto.File.UserProto>(
                  this, METHODID_CREATE_USER)))
          .build();
    }
  }

  /**
   */
  public static final class SerivceStub extends io.grpc.stub.AbstractStub<SerivceStub> {
    private SerivceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SerivceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SerivceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SerivceStub(channel, callOptions);
    }

    /**
     */
    public void getShelf(GRPC.proto.File.ShelfSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SHELF, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateShelf(GRPC.proto.File.ShelfProto request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SHELF, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllShelves(GRPC.proto.File.getAllRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ShelvesListProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_SHELVES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createItemType(GRPC.proto.File.ItemTypeCreationRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_ITEM_TYPE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readItemType(GRPC.proto.File.ItemTypeSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ITEM_TYPE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createItem(GRPC.proto.File.ItemCreation request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_ITEM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readItem(GRPC.proto.File.ItemSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_ITEM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteItem(GRPC.proto.File.ItemSearchRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_ITEM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUser(GRPC.proto.File.CreateUserRequest request,
        io.grpc.stub.StreamObserver<GRPC.proto.File.UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SerivceBlockingStub extends io.grpc.stub.AbstractStub<SerivceBlockingStub> {
    private SerivceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SerivceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SerivceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SerivceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPC.proto.File.ShelfProto getShelf(GRPC.proto.File.ShelfSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SHELF, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ShelfProto updateShelf(GRPC.proto.File.ShelfProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_SHELF, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ShelvesListProto getAllShelves(GRPC.proto.File.getAllRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_SHELVES, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemTypeProto createItemType(GRPC.proto.File.ItemTypeCreationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_ITEM_TYPE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemTypeProto readItemType(GRPC.proto.File.ItemTypeSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ITEM_TYPE, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemProto createItem(GRPC.proto.File.ItemCreation request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_ITEM, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemProto readItem(GRPC.proto.File.ItemSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_ITEM, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.ItemProto deleteItem(GRPC.proto.File.ItemSearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_ITEM, getCallOptions(), request);
    }

    /**
     */
    public GRPC.proto.File.UserProto createUser(GRPC.proto.File.CreateUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_USER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SerivceFutureStub extends io.grpc.stub.AbstractStub<SerivceFutureStub> {
    private SerivceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SerivceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SerivceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SerivceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelfProto> getShelf(
        GRPC.proto.File.ShelfSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SHELF, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelfProto> updateShelf(
        GRPC.proto.File.ShelfProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_SHELF, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ShelvesListProto> getAllShelves(
        GRPC.proto.File.getAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_SHELVES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemTypeProto> createItemType(
        GRPC.proto.File.ItemTypeCreationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_ITEM_TYPE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemTypeProto> readItemType(
        GRPC.proto.File.ItemTypeSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ITEM_TYPE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemProto> createItem(
        GRPC.proto.File.ItemCreation request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_ITEM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemProto> readItem(
        GRPC.proto.File.ItemSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_ITEM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.ItemProto> deleteItem(
        GRPC.proto.File.ItemSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_ITEM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.proto.File.UserProto> createUser(
        GRPC.proto.File.CreateUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SHELF = 0;
  private static final int METHODID_UPDATE_SHELF = 1;
  private static final int METHODID_GET_ALL_SHELVES = 2;
  private static final int METHODID_CREATE_ITEM_TYPE = 3;
  private static final int METHODID_READ_ITEM_TYPE = 4;
  private static final int METHODID_CREATE_ITEM = 5;
  private static final int METHODID_READ_ITEM = 6;
  private static final int METHODID_DELETE_ITEM = 7;
  private static final int METHODID_CREATE_USER = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SerivceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SerivceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SHELF:
          serviceImpl.getShelf((GRPC.proto.File.ShelfSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto>) responseObserver);
          break;
        case METHODID_UPDATE_SHELF:
          serviceImpl.updateShelf((GRPC.proto.File.ShelfProto) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelfProto>) responseObserver);
          break;
        case METHODID_GET_ALL_SHELVES:
          serviceImpl.getAllShelves((GRPC.proto.File.getAllRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ShelvesListProto>) responseObserver);
          break;
        case METHODID_CREATE_ITEM_TYPE:
          serviceImpl.createItemType((GRPC.proto.File.ItemTypeCreationRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeProto>) responseObserver);
          break;
        case METHODID_READ_ITEM_TYPE:
          serviceImpl.readItemType((GRPC.proto.File.ItemTypeSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemTypeProto>) responseObserver);
          break;
        case METHODID_CREATE_ITEM:
          serviceImpl.createItem((GRPC.proto.File.ItemCreation) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto>) responseObserver);
          break;
        case METHODID_READ_ITEM:
          serviceImpl.readItem((GRPC.proto.File.ItemSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto>) responseObserver);
          break;
        case METHODID_DELETE_ITEM:
          serviceImpl.deleteItem((GRPC.proto.File.ItemSearchRequest) request,
              (io.grpc.stub.StreamObserver<GRPC.proto.File.ItemProto>) responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser((GRPC.proto.File.CreateUserRequest) request,
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

  private static final class SerivceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPC.proto.File.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SerivceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SerivceDescriptorSupplier())
              .addMethod(METHOD_GET_SHELF)
              .addMethod(METHOD_UPDATE_SHELF)
              .addMethod(METHOD_GET_ALL_SHELVES)
              .addMethod(METHOD_CREATE_ITEM_TYPE)
              .addMethod(METHOD_READ_ITEM_TYPE)
              .addMethod(METHOD_CREATE_ITEM)
              .addMethod(METHOD_READ_ITEM)
              .addMethod(METHOD_DELETE_ITEM)
              .addMethod(METHOD_CREATE_USER)
              .build();
        }
      }
    }
    return result;
  }
}
