package net.andresbustamante.mystore.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Integer id;
    private String line1;
    private String line2;
    private String postalCode;
    private CityDto city;
}
