package net.andresbustamante.mystore.api.model;

import java.util.Arrays;
import java.util.Objects;

public record CustomerCreation(
        String firstName, String lastName, String email, String phoneNumber, String username, byte[] password,
        String addressLine1, String addressLine2, String postalCode, Integer cityId) {

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerCreation that = (CustomerCreation) o;
        return Objects.equals(email, that.email) && Objects.equals(lastName, that.lastName)
                && Objects.equals(username, that.username) && Objects.deepEquals(password, that.password)
                && Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, username, Arrays.hashCode(password));
    }
}
