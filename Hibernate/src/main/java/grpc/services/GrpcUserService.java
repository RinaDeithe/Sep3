package grpc.services;

import GRPC.proto.File;
import GRPC.proto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GrpcUserService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void create(File.CreateUserRequest request, StreamObserver<File.UserProto> responseObserver) {
        super.create(request, responseObserver);
    }

    @Override
    public void read(File.UserSearchRequest request, StreamObserver<File.UserProto> responseObserver) {
        super.read(request, responseObserver);
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.UserListProto> responseObserver) {
        super.readAll(request, responseObserver);
    }

    @Override
    public void delete(File.UserSearchRequest request, StreamObserver<File.UserProto> responseObserver) {
        super.delete(request, responseObserver);
    }
}
