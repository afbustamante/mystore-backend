package net.andresbustamante.mystore.core.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @Column(name = "email", length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "phone", length = 50)
    private String phone;

    private Short age;

    private Integer income;

    @Size(max = 1)
    @Column(name = "gender", length = 1)
    private String gender;

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_customers_user"))
    private User user;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customers_address"))
    private Address address;
}
