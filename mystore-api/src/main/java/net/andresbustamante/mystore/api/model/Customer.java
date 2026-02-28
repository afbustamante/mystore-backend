package net.andresbustamante.mystore.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends Person {

    private Integer id;
    private String username;
    private String email;
    private String phoneNumber;
}
