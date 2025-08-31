package net.andresbustamante.mystore.core.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;
import net.andresbustamante.mystore.api.model.Gender;
import net.andresbustamante.mystore.core.util.GenderConverter;

@MappedSuperclass
@Getter
@Setter
public class Person implements Serializable {

    @Size(max = 50)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Size(max = 50)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "gender", length = 1)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Transient
    public String getFullName() {
        return String.join(StringUtils.SPACE, firstName, lastName);
    }
}
