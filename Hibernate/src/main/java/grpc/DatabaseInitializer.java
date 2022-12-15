package grpc;

import database.daoInterfaces.IDbDao;
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
        System.out.println("Adding gRPC services...");
        IDbDao<Item> itemDao = new DbConnection<>();
        IDbDao<ItemType> typeDao = new DbConnection<>();
        IDbDao<Shelf> shelfDao = new DbConnection<>();
        IDbDao<User> userDao = new DbConnection<>();
        Server server = ServerBuilder.forPort(9090)
                .addService(new GrpcItemService(itemDao, shelfDao))
                .addService(new GrpcItemTypeService(typeDao))
                .addService(new GrpcShelfService(shelfDao))
                .addService(new GrpcUserService(userDao))
                .build();
        System.out.println("Starting server.");
        server.start();
        System.out.println("Server started.");
        server.awaitTermination();
    }

}
