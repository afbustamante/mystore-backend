package net.andresbustamante.mystore.api.model;

public record CustomerUpdateDto(
        String firstName, String lastName, String email, String phoneNumber) {
}
