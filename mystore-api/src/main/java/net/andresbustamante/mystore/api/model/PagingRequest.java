package net.andresbustamante.mystore.api.model;

public record PagingRequest(Integer pageNumber, Integer pageSize) {

    public static PagingRequest of(Integer pageNumber, Integer pageSize) {
        return new PagingRequest(pageNumber, pageSize);
    }

}
