package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ShelfServiceGrpc;
import database.daoInterfaces.IDbDao;
import domain.Model.Shelf;
import grpc.converter.ShelfConverter;
import io.grpc.stub.StreamObserver;

import java.util.List;
public class GrpcShelfService extends ShelfServiceGrpc.ShelfServiceImplBase {

    IDbDao<Shelf> dao;

    public GrpcShelfService(IDbDao<Shelf> shelfDbDao) {
        dao = shelfDbDao;
    }

    @Override
    public void create(File.ShelfCreationRequest request, StreamObserver<File.ShelfProto> responseObserver) {
        Shelf shelf = dao.Create(ShelfConverter.CONVERT.toShelfFromCreation(request));

        File.ShelfProto proto = ShelfConverter.CONVERT.toShelfProto(shelf);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void read(File.ShelfSearchRequest request, StreamObserver<File.ShelfProto> responseObserver) {
        Shelf readShelf = ShelfConverter.CONVERT.toShelfFromSearch(request);
        Shelf shelf = dao.Read(new Shelf(), readShelf.getId());

        File.ShelfProto proto = ShelfConverter.CONVERT.toShelfProto(shelf);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ShelvesListProto> responseObserver) {
        List<Shelf> shelfList = dao.ReadAll(new Shelf());

        for (Shelf shelf:shelfList
             ) {
            System.out.println("item = " + shelf.getItemsOnShelf());
        }

        File.ShelvesListProto proto = ShelfConverter.CONVERT.toShelfProtoFromList(shelfList);
        System.out.println(proto);
        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void update(File.ShelfProto request, StreamObserver<File.ShelfProto> responseObserver) {
        File.ShelfProto proto = ShelfConverter.CONVERT.toShelfProto(dao.Update(ShelfConverter.CONVERT.toShelfFromProto(request)));

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(File.ShelfSearchRequest request, StreamObserver<File.ShelfProto> responseObserver) {
        Shelf shelf = dao.Delete(ShelfConverter.CONVERT.toShelfFromSearch(request));

        File.ShelfProto proto = ShelfConverter.CONVERT.toShelfProto(shelf);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }
}
