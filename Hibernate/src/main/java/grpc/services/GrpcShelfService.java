package grpc.services;

import GRPC.proto.File;
import GRPC.proto.ShelfServiceGrpc;
import database.daoInterfaces.IDbDao;
import database.daos.DbDao;
import domain.Model.Shelf;
import grpc.converter.ShelfConverter;
import io.grpc.stub.StreamObserver;

import java.util.List;
// SHELF CONVERTER OG DE DIVERSE SHELF PROTO MESSAGES SKAL OPDATERERS TIL IKKE KUN AT HAVE 1 ID, MEN 2.
public class GrpcShelfService extends ShelfServiceGrpc.ShelfServiceImplBase {

    IDbDao<Shelf> dao;

    public GrpcShelfService(DbDao<Shelf> shelfDbDao) {
        dao = shelfDbDao;
    }

    @Override
    public void update(File.ItemProto request, StreamObserver<File.ItemProto> responseObserver) {
        super.update(request, responseObserver);
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
        Shelf shelf = dao.Read(new Shelf(), request.getId());

        File.ShelfProto proto = ShelfConverter.CONVERT.toShelfProto(shelf);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.ShelvesListProto> responseObserver) {
        List<Shelf> shelfList = dao.ReadAll(new Shelf());

        File.ShelvesListProto proto = ShelfConverter.CONVERT.toShelfProtoFromList(shelfList);

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
