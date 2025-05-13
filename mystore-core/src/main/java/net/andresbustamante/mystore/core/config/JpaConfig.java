package net.andresbustamante.mystore.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(value = "net.andresbustamante.mystore.core.dao")
@EnableTransactionManagement
public class JpaConfig {
}
