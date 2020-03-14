package com.lbstecnologia.erp.app.models.dtos;

import com.lbstecnologia.erp.app.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO implements Serializable {

    private String nome;
    private StatusEnum status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
