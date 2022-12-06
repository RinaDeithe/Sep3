
import GRPCMethodCall.GRPCDataBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Database {
    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder.forPort(9090)
                .addService(new GRPCDataBase())
                .build();
        server.start();
        server.awaitTermination();


    }

}
