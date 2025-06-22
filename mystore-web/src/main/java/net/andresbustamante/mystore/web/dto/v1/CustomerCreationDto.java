package net.andresbustamante.mystore.web.dto.v1;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreationDto {

    @NotNull
    @Size(min = 2, max = 50)
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @NotNull
    @Size(min = 2, max = 50)
    @Email
    private String email;

    @Size(min = 2, max = 50)
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotNull
    @Size(min = 2, max = 20)
    private String username;

    @NotNull
    private byte[] password;

    @NotNull
    @Size(min = 2, max = 50)
    @JsonProperty("address_line_1")
    private String addressLine1;

    @Size(min = 2, max = 50)
    @JsonProperty("address_line_2")
    private String addressLine2;

    @NotNull
    @Size(min = 2, max = 9)
    @JsonProperty("postal_code")
    private String postalCode;

    @NotNull
    @Positive
    @JsonProperty("city_id")
    private Integer cityId;
}
