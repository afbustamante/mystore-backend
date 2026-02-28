package net.andresbustamante.mystore.api.model;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum Gender {

    MASCULINE("M"),
    FEMININE("F");

    private final String code;

    Gender(final String code) {
        this.code = code;
    }

    public static Gender fromCode(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Gender.values())
                .filter(gender -> gender.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
