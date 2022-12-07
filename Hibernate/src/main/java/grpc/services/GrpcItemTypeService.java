package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ItemTypeServiceGrpc;
import database.daoInterfaces.IDbDao;
import domain.Model.ItemType;
import grpc.converter.ItemTypeConverter;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class GrpcItemTypeService extends ItemTypeServiceGrpc.ItemTypeServiceImplBase {

    IDbDao<ItemType> dao;

    public GrpcItemTypeService(IDbDao<ItemType> dao) {
        this.dao = dao;
    }

    @Override
    public void create(File.ItemTypeCreationRequest request, StreamObserver<File.ItemTypeProto> responseObserver) {
        ItemType type = dao.Create(ItemTypeConverter.CONVERT.toTypeFromSearch(request));

        File.ItemTypeProto proto = ItemTypeConverter.CONVERT.toTypeProtoFromType(type);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void read(File.ItemTypeSearchRequest request, StreamObserver<File.ItemTypeProto> responseObserver) {
        ItemType type = dao.Read(new ItemType(), request.getId());

        File.ItemTypeProto proto = ItemTypeConverter.CONVERT.toTypeProtoFromType(type);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ItemTypeListProto> responseObserver) {
        List<ItemType> typeList = dao.ReadAll(new ItemType());

        File.ItemTypeListProto proto = ItemTypeConverter.CONVERT.toTypeProtoFromList(typeList);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(File.ItemTypeSearchRequest request, StreamObserver<File.ItemTypeProto> responseObserver) {
        ItemType type = dao.Delete(ItemTypeConverter.CONVERT.toTypeFromSearch(request));

        File.ItemTypeProto proto = ItemTypeConverter.CONVERT.toTypeProto(type);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }
}
