package net.andresbustamante.mystore.api.exceptions;

public class AccessDeniedException extends SecurityException {

    public AccessDeniedException(String message) {
        super(message);
    }
}
