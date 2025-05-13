package net.andresbustamante.mystore.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends Person {

    private String username;
    private byte[] password;
    private String email;
    private String phoneNumber;
}
