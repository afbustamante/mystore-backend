package net.andresbustamante.mystore.api.model;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page<T> {

    private int pageNumber;
    private int pageSize;
    private int totalElements;

    private Collection<T> elements;
}
