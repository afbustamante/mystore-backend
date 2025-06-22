package net.andresbustamante.mystore.api.exceptions;

public class FunctionalException extends ApplicationException {

    protected FunctionalException(String message) {
        super(message);
    }

    protected FunctionalException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
