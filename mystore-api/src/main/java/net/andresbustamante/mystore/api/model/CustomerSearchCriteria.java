package net.andresbustamante.mystore.api.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerSearchCriteria {

    private String name;
    private String country;
}
