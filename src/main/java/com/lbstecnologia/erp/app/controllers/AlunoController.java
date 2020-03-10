package com.lbstecnologia.erp.app.controllers;

import com.lbstecnologia.erp.app.models.Aluno;
import com.lbstecnologia.erp.app.models.dtos.AlunoDTO;
import com.lbstecnologia.erp.app.services.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody AlunoDTO aluno) {

        Long idAluno = alunoService.inserir(aluno);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(idAluno).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> editar(
            @PathVariable Long id,
            @Valid @RequestBody AlunoDTO aluno
    ) {
        alunoService.editar(id, aluno);
        return ResponseEntity.noContent().build();
    }

}
