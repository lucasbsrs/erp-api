package com.lbstecnologia.erp.app.models.dtos;

import com.lbstecnologia.erp.app.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO implements Serializable {

    private String nome;
    private String cpf;
    private String endereco;
    private String usuario;
    private StatusEnum status;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

}
