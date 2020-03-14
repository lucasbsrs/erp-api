package com.lbstecnologia.erp.app.services;

import com.lbstecnologia.erp.app.enums.StatusEnum;
import com.lbstecnologia.erp.app.models.Aluno;
import com.lbstecnologia.erp.app.models.Professor;
import com.lbstecnologia.erp.app.repositories.AlunoRepository;
import com.lbstecnologia.erp.app.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public void instantiateTestDatabase()  {

        Aluno a1 = Aluno.builder()
                .id(1L)
                .cpf("02178566644")
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(LocalDateTime.now())
                .endereco("Rua XYZ")
                .nome("Lucas Silva")
                .status(StatusEnum.ATIVO)
                .usuario("lucasuser")
                .build();

        alunoRepository.saveAll(Arrays.asList(a1));

        Professor p1 = Professor.builder()
                .id(1L)
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(LocalDateTime.now())
                .nome("Professor Lucas")
                .status(StatusEnum.ATIVO)
                .build();

        professorRepository.saveAll(Arrays.asList(p1));
    }
}