package ie.atu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Cicd1OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Cicd1OrderServiceApplication.class, args);
    }

}
