package grpc;

import database.daos.DbDao;
import database.orm.DbConnection;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import grpc.services.GrpcItemService;
import grpc.services.GrpcItemTypeService;
import grpc.services.GrpcShelfService;
import grpc.services.GrpcUserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DatabaseInitializer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new GrpcItemService(new DbDao<Item>(new DbConnection<Item>())))
                .addService(new GrpcItemTypeService(new DbDao<ItemType>(new DbConnection<ItemType>())))
                .addService(new GrpcShelfService(new DbDao<Shelf>(new DbConnection<Shelf>())))
                .addService(new GrpcUserService(new DbDao<User>(new DbConnection<User>())))
                .build();
        server.start();
        server.awaitTermination();
    }

}
