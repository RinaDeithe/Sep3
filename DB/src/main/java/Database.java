
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Database {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(Database.class,args);


    }

}
