package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ItemServiceGrpc;
import database.daoInterfaces.IDbDao;
import domain.Model.Item;
import grpc.converter.ItemConverter;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class GrpcItemService extends ItemServiceGrpc.ItemServiceImplBase {

    IDbDao<Item> dao;

    public GrpcItemService(IDbDao<Item> dao) {
        this.dao = dao;
    }

    @Override
    public void create(File.ItemCreation request, StreamObserver<File.ItemProto> responseObserver) {
        Item item = dao.Create(ItemConverter.CONVERT.toItemFromCreation(request));

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void read(File.ItemSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        Item item = dao.Read(new Item(), request.getId());

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ItemListProto> responseObserver) {
        List<Item> itemList = dao.ReadAll(new Item());

        File.ItemListProto proto = ItemConverter.CONVERT.toItemProtoFromList(itemList);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(File.ItemSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        Item item = dao.Delete(new Item(request.getId(), null, null, null));

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }
}