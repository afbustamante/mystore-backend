package net.andresbustamante.mystore.api.exceptions;

public class TechnicalException extends ApplicationException {

    protected TechnicalException(String message) {
        super(message);
    }

    protected TechnicalException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
