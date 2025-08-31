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

import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@SoftDelete(strategy = SoftDeleteType.ACTIVE, columnName = "active")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 64)
    @NotNull
    @Column(name = "password", nullable = false, length = 64)
    private String password;
}
