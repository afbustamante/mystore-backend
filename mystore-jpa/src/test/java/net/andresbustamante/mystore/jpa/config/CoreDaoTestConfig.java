package net.andresbustamante.mystore.jpa.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({
        DbUnitTestConfig.class,
        JpaConfig.class,
        JpaTestConfig.class
})
public class CoreDaoTestConfig {
}
