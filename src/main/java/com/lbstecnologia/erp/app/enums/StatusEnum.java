package com.lbstecnologia.erp.app.enums;

import lombok.Getter;

public enum StatusEnum {

    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    @Getter
    private String codigo;

    StatusEnum(String codigo) {
        this.codigo = codigo;
    }
}
