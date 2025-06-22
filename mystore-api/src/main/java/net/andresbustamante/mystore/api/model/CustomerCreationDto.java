package net.andresbustamante.mystore.api.model;

public record CustomerCreationDto(
        String firstName, String lastName, String email, String phoneNumber, String username,byte[] password,
        String addressLine1, String addressLine2, String postalCode, Integer cityId) {
}
