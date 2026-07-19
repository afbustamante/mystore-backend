package net.andresbustamante.mystore.api.exceptions;

public class DatabaseException extends TechnicalException {

    public DatabaseException(final String message) {
        super(message);
    }

    public DatabaseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
