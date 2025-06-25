package net.andresbustamante.mystore.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto extends PersonDto {

    private Integer id;
    private String username;
    private String email;
    private String phoneNumber;
}
