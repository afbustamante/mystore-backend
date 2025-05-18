package net.andresbustamante.mystore.core.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Size(max = 50)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Size(max = 50)
    @NotNull
    @Column(name = "address_1", nullable = false, length = 50)
    private String address1;

    @Size(max = 50)
    @Column(name = "address_2", length = 50)
    private String address2;

    @Size(max = 50)
    @NotNull
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "state", length = 50)
    private String state;

    @Size(max = 9)
    @Column(name = "zip", length = 9)
    private String zip;

    @Size(max = 50)
    @NotNull
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @NotNull
    @Column(name = "region", nullable = false)
    private Short region;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "phone", length = 50)
    private String phone;

    @NotNull
    @Column(name = "credit_card_type")
    private Integer creditCardType;

    @Size(max = 50)
    @NotNull
    @Column(name = "credit_card_number", nullable = false, length = 50)
    private String creditCard;

    @Size(max = 50)
    @NotNull
    @Column(name = "credit_card_expiration_date", nullable = false, length = 50)
    private String creditCardExpiration;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    private Short age;

    private Integer income;

    @Size(max = 1)
    @Column(name = "gender", length = 1)
    private String gender;

}
