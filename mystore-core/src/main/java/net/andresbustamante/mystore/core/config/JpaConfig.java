package net.andresbustamante.mystore.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(value = "net.andresbustamante.mystore.core.dao")
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
@EnableTransactionManagement
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new JpaAuditorAware();
    }
}
