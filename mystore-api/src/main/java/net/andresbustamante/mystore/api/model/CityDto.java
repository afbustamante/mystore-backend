package net.andresbustamante.mystore.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {

    private Integer id;
    private String name;
    private CountryDto country;
}
