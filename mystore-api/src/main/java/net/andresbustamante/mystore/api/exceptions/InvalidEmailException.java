package net.andresbustamante.mystore.api.exceptions;

public class InvalidEmailException extends FunctionalException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
