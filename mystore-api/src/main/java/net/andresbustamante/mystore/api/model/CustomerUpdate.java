package net.andresbustamante.mystore.api.model;

public record CustomerUpdate(
        String firstName, String lastName, String email, String phoneNumber) {
}
