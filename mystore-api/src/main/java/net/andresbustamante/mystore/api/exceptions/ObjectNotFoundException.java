package net.andresbustamante.mystore.api.exceptions;

public class ObjectNotFoundException extends FunctionalException {

    public ObjectNotFoundException(final String message) {
        super(message);
    }
}
