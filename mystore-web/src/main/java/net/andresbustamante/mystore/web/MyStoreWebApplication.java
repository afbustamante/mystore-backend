package net.andresbustamante.mystore.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "net.andresbustamante.mystore")
@EntityScan(basePackages = "net.andresbustamante.mystore.jpa.entities")
@EnableScheduling
@EnableAsync
@EnableCaching
public class MyStoreWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoreWebApplication.class, args);
    }
}
