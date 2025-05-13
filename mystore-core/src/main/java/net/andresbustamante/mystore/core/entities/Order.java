package net.andresbustamante.mystore.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "orderdate")
    private LocalDate orderDate;

    @ManyToOne
    //@org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.SET_NULL)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @NotNull
    @Column(name = "netamount", nullable = false)
    private BigDecimal netAmount;

    @NotNull
    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @NotNull
    @Column(name = "totalamount", nullable = false)
    private BigDecimal totalAmount;
}
