package net.andresbustamante.mystore.api.util;

public record PagingRequest(Integer pageNumber, Integer pageSize) {

    public static PagingRequest of(Integer pageNumber, Integer pageSize) {
        return new PagingRequest(pageNumber, pageSize);
    }

}
