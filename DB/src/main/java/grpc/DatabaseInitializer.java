package grpc;

import GRPCMethodCall.GRPCDataBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DatabaseInitializer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new GRPCDataBase())
                .build();
        server.start();
        server.awaitTermination();
    }

}
