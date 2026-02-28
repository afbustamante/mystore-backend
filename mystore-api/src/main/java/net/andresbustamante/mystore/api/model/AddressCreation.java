package net.andresbustamante.mystore.api.model;

public record AddressCreation(
        String line1, String line2, String postalCode, Integer cityId) {
}
