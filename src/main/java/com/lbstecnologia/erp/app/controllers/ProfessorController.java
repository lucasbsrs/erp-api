package com.lbstecnologia.erp.app.controllers;

import com.lbstecnologia.erp.app.models.Professor;
import com.lbstecnologia.erp.app.models.dtos.AlunoDTO;
import com.lbstecnologia.erp.app.models.dtos.ProfessorDTO;
import com.lbstecnologia.erp.app.services.AlunoService;
import com.lbstecnologia.erp.app.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody ProfessorDTO professor) {

        Long idProfessor = professorService.inserir(professor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(idProfessor).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> editar(
            @PathVariable Long id,
            @Valid @RequestBody ProfessorDTO professor
    ) {
        professorService.editar(id, professor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> buscarTodos() {
        List<ProfessorDTO> itens = professorService.buscarTodos();

        return ResponseEntity.ok().body(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> buscarPorId(@PathVariable Long id) {
        ProfessorDTO professor = professorService.buscarPoId(id);

        return ResponseEntity.ok().body(professor);
    }

    @DeleteMapping(value = "/{idProfessor}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long idProfessor) {

        professorService.excluir(idProfessor);
        return ResponseEntity.noContent().build();
    }

}
