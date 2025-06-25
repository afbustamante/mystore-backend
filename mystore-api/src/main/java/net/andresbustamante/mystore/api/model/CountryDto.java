package net.andresbustamante.mystore.api.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto {

    private Integer id;
    private String name;
    private Set<CityDto> cities;
}
