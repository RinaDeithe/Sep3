package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ShelfServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GrpcShelfService extends ShelfServiceGrpc.ShelfServiceImplBase {
    @Override
    public void create(File.ShelfCreationRequest request, StreamObserver<File.ShelfProto> responseObserver) {
        super.create(request, responseObserver);
    }

    @Override
    public void read(File.ShelfSearchRequest request, StreamObserver<File.ShelfProto> responseObserver) {
        super.read(request, responseObserver);
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ShelvesListProto> responseObserver) {
        super.readAll(request, responseObserver);
    }

    @Override
    public void delete(File.ShelfSearchRequest request, StreamObserver<File.ShelfProto> responseObserver) {
        super.delete(request, responseObserver);
    }
}
