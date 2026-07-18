package net.andresbustamante.mystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "net.andresbustamante.mystore.jpa.entities")
public class MyStoreWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoreWebApplication.class, args);
    }
}
