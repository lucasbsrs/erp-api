package com.lbstecnologia.erp.app.models;

import com.lbstecnologia.erp.app.enums.StatusConverter;
import com.lbstecnologia.erp.app.enums.StatusEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Entity
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 200)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "ENDERECO", nullable = false, length = 200)
    private String endereco;

    @Column(name = "STATUS", nullable = false)
    @Convert(converter = StatusConverter.class)
    private StatusEnum status;

    @Column(name = "USUARIO", nullable = false, length = 50)
    private String usuario;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

}
