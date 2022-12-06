package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ItemTypeServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GrpcItemTypeService extends ItemTypeServiceGrpc.ItemTypeServiceImplBase {
    @Override
    public void create(File.ItemTypeCreationRequest request, StreamObserver<File.ItemProto> responseObserver) {
        super.create(request, responseObserver);
    }

    @Override
    public void read(File.ItemTypeSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        super.read(request, responseObserver);
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ItemTypeListProto> responseObserver) {
        super.readAll(request, responseObserver);
    }

    @Override
    public void delete(File.ItemTypeSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        super.delete(request, responseObserver);
    }
}
