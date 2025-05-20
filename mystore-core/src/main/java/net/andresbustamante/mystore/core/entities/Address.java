package net.andresbustamante.mystore.core.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "line_1", nullable = false, length = 50)
    private String line1;

    @Size(max = 50)
    @Column(name = "line_2", length = 50)
    private String line2;

    @Size(max = 9)
    @Column(name = "postal_code", length = 9)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
