package com.semillerogtc.gtcusermanagament.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TelefonoAttributeConverter implements AttributeConverter<Telefono, String>{
    @Override
    public String convertToDatabaseColumn(Telefono attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Telefono convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Telefono(dbData);
    }
}
