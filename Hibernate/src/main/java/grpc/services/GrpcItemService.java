package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ItemServiceGrpc;
import database.daoInterfaces.IDbDao;
import domain.Model.Item;
import grpc.adapter.User.CreateUserAdapterDB;
import grpc.converter.ItemConverter;
import io.grpc.stub.StreamObserver;

public class GrpcItemService extends ItemServiceGrpc.ItemServiceImplBase {

    IDbDao<Item> dao;
    ItemConverter converter;

    public GrpcItemService(IDbDao<Item> dao, ItemConverter converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    public void create(File.ItemCreation request, StreamObserver<File.ItemProto> responseObserver) {



        CreateUserAdapterDB createUserAdapterDB = new CreateUserAdapterDB(null);
        File.UserProto userRespond = null;


        userRespond = createUserAdapterDB.CreateUser(dao);

        userResponse.onNext(userRespond);
        userResponse.onCompleted();

        super.create(request, responseObserver);
    }

    @Override
    public void read(File.ItemSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        super.read(request, responseObserver);
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ItemListProto> responseObserver) {
        super.readAll(request, responseObserver);
    }

    @Override
    public void delete(File.ItemSearchRequest request, StreamObserver<File.ItemProto> responseObserver) {
        super.delete(request, responseObserver);
    }
}
