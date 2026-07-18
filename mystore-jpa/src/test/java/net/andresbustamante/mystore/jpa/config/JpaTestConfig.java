package net.andresbustamante.mystore.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "net.andresbustamante.mystore.jpa.entities")
public class JpaTestConfig {
}
