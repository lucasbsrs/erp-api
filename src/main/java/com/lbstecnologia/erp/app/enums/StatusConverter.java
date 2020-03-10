package com.lbstecnologia.erp.app.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
    public class StatusConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum status) {
        if (status != null) {
            return status.getCodigo();
        } else {
            return null;
        }
    }

    @Override
    public StatusEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (StatusEnum x : StatusEnum.values()) {
            if (dbData.toUpperCase().equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + dbData);
    }

}