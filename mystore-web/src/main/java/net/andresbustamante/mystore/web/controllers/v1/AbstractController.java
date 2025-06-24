package net.andresbustamante.mystore.web.controllers.v1;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

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
}
