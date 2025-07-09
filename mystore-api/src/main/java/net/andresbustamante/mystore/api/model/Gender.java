package net.andresbustamante.mystore.api.model;

import lombok.Getter;

@Getter
public enum Gender {

    MASCULINE("M"),
    FEMININE("F");

    private final String code;

    Gender(final String code) {
        this.code = code;
    }
}
