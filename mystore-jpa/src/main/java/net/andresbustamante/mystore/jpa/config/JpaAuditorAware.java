package net.andresbustamante.mystore.jpa.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import net.andresbustamante.mystore.api.util.UserContextHolder;

public class JpaAuditorAware implements AuditorAware<String> {

    public static final String DEFAULT_USERNAME = "UNKNOWN";

    @Override
    public @NonNull Optional<String> getCurrentAuditor() {
        return UserContextHolder.getUserContext() != null ? Optional.of(UserContextHolder.getUserContext().getUsername()) : Optional.of(DEFAULT_USERNAME);
    }
}
