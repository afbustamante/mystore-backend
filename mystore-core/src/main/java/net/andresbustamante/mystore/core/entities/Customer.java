package net.andresbustamante.mystore.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Email
    @Column(name = "email", length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "phone", length = 50)
    private String phoneNumber;

    @PositiveOrZero
    private Integer income;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_customers_user"))
    private User user;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customers_address"))
    private Address address;
}
