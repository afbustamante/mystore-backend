package net.andresbustamante.mystore.api.exceptions;

public class InvalidUsernameException extends FunctionalException {

    public InvalidUsernameException(String message) {
        super(message);
    }
}
