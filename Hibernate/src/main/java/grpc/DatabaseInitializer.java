package grpc;

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
        Server server = ServerBuilder.forPort(9090)
                .addService(new GrpcItemService(new DbConnection<Item>()))
                .addService(new GrpcItemTypeService(new DbConnection<ItemType>()))
                .addService(new GrpcShelfService(new DbConnection<Shelf>()))
                .addService(new GrpcUserService(new DbConnection<User>()))
                .build();
        System.out.println("Starting server.");
        server.start();
        System.out.println("Server started.");
        server.awaitTermination();
    }

}
