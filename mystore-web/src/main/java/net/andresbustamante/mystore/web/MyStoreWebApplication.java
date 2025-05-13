package net.andresbustamante.mystore.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "net.andresbustamante.mystore")
@EntityScan(basePackages = "net.andresbustamante.mystore.core.entities")
@EnableScheduling
@EnableAsync
public class MyStoreWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoreWebApplication.class, args);
    }
}
