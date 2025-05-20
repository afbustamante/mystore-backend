package net.andresbustamante.mystore.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(
        JpaConfig.class
)
@EntityScan(basePackages = "net.andresbustamante.mystore.core.entities")
public class CoreDaoTestConfig {
}
