package net.andresbustamante.mystore.web.controllers.v1;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.mystore.api.util.UserContext;

public abstract class AbstractController {

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    protected AbstractController(final ObjectMapper objectMapper, final HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.of(objectMapper);
    }

    public Optional<HttpServletRequest> getRequest() {
        return Optional.of(request);
    }

    public UserContext getUserContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
                ? new UserContext(authentication.getName()) : UserContext.UNKNOWN_USER;
    }
}
