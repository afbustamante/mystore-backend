package net.andresbustamante.mystore.api.exceptions;

public class SecurityException extends ApplicationException {

    protected SecurityException(String message) {
        super(message);
    }

    protected SecurityException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
