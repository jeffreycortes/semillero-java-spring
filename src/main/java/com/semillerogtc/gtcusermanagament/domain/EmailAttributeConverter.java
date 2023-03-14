package com.semillerogtc.gtcusermanagament.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EmailAttributeConverter implements AttributeConverter<Email, String>{
    @Override
    public String convertToDatabaseColumn(Email attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Email convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Email(dbData);
    }
}
