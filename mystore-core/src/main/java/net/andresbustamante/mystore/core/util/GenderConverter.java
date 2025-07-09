package net.andresbustamante.mystore.core.util;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import net.andresbustamante.mystore.api.model.Gender;

@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(final Gender gender) {
        return gender != null ? gender.getCode() : null;
    }

    @Override
    public Gender convertToEntityAttribute(final String code) {
        return Stream.of(Gender.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
