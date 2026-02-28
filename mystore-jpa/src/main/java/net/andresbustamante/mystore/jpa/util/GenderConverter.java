package net.andresbustamante.mystore.jpa.util;

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
        return Gender.fromCode(code);
    }
}
