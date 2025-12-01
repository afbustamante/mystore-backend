package net.andresbustamante.mystore.core.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JpaAuditorAware implements AuditorAware<String> {

    public static final String DEFAULT_USERNAME = "UNKNOWN";

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
                ? Optional.of(authentication.getName()) : Optional.of(DEFAULT_USERNAME);
    }
}
