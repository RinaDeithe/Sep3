package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ItemServiceGrpc;
import database.daoInterfaces.IDbDao;
import domain.Model.Item;
import domain.Model.Shelf;
import grpc.converter.ItemConverter;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class GrpcItemService extends ItemServiceGrpc.ItemServiceImplBase {

    IDbDao<Item> itemDao;
    IDbDao<Shelf> shelfDao;

    public GrpcItemService(IDbDao<Item> dao, IDbDao<Shelf> shelfDao) {
        this.itemDao = dao;
        this.shelfDao = shelfDao;
    }

    @Override
    public void create(File.ItemCreation request, StreamObserver<File.ItemProto> responseObserver) {
        //Getting the shelf the item is on for later use.
        Shelf updatedShelf = shelfDao.Read(new Shelf(), Integer.parseInt(request.getShelfID()));
        if (updatedShelf.getItemsOnShelf() == null)
            updatedShelf.setItemsOnShelf(new ArrayList<>());

        //Creating Item.
        Item requestResult = ItemConverter.CONVERT.toItemFromCreation(request, updatedShelf);
        System.out.println(requestResult);
        Item item = itemDao.Create(requestResult);

        //Updating Shelf, so item is also in shelf object.
        System.out.println(updatedShelf.getItemsOnShelf());
        updatedShelf.getItemsOnShelf().add(item);
        System.out.println(updatedShelf.getItemsOnShelf());
        shelfDao.Update(updatedShelf);

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void read(File.ItemSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        Item item = itemDao.Read(new Item(),  request.getId());

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ItemListProto> responseObserver) {
        List<Item> itemList = itemDao.ReadAll(new Item());

        File.ItemListProto proto = ItemConverter.CONVERT.toProtoFromList(itemList);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void update(File.ItemProto request, StreamObserver<File.ItemProto> responseObserver) {
        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(itemDao.Update(ItemConverter.CONVERT.toItemFromProto(request)));

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(File.ItemSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        Item item = itemDao.Delete(new Item(request.getId(), null, null,null));

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }
}
