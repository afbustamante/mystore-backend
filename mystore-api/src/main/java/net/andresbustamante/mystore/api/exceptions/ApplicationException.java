package net.andresbustamante.mystore.api.exceptions;

public class ApplicationException extends Exception {

    protected ApplicationException(String message) {
        super(message);
    }

    protected ApplicationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
