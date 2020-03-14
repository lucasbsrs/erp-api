package com.lbstecnologia.erp.app.services;

import com.lbstecnologia.erp.app.enums.StatusEnum;
import com.lbstecnologia.erp.app.models.Aluno;
import com.lbstecnologia.erp.app.models.Professor;
import com.lbstecnologia.erp.app.models.dtos.AlunoDTO;
import com.lbstecnologia.erp.app.models.dtos.ProfessorDTO;
import com.lbstecnologia.erp.app.repositories.AlunoRepository;
import com.lbstecnologia.erp.app.repositories.ProfessorRepository;
import com.lbstecnologia.erp.app.utils.ServiceAbstract;
import com.lbstecnologia.erp.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService extends ServiceAbstract {

    @Autowired
    private ProfessorRepository professorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Long inserir(ProfessorDTO dto) {
        Professor professor = modelMapper.map(dto, Professor.class);
        professor.setDataCriacao(LocalDateTime.now());
        professor .setDataAtualizacao(LocalDateTime.now());

        professor = professorRepository.save(professor);

        return professor.getId();
    }

    @Transactional
    public void editar(Long id, ProfessorDTO dto) {
        Professor professor = professorRepository.findById(id).orElse(null);
        verificaObjeto(professor, ObjectNotFoundException.PROFESSOR_NAO_ENCONTRADO);

        Professor entity = modelMapper.map(dto, Professor.class);
        entity.setId(professor.getId());
        entity.setDataCriacao(professor.getDataCriacao());
        entity.setDataAtualizacao(LocalDateTime.now());

        professorRepository.save(entity);
    }

    public List<ProfessorDTO> buscarTodos() {
        List<Professor> listaProfessores = professorRepository.findAll();

        verificaObjeto(listaProfessores, ObjectNotFoundException.PROFESSOR_NAO_ENCONTRADO);

        return listaProfessores.stream()
                .map(item -> modelMapper.map(item, ProfessorDTO.class))
                .collect(Collectors.toList());

    }

    public ProfessorDTO buscarPoId(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(ObjectNotFoundException.PROFESSOR_NAO_ENCONTRADO));

        return modelMapper.map(professor, ProfessorDTO.class);
    }

    @Transactional
    public void excluir(Long id) {
        Professor professor = professorRepository.findById(id).orElse(null);
        ProfessorDTO dto = modelMapper.map(professor, ProfessorDTO.class);

        verificaObjeto(professor, ObjectNotFoundException.PROFESSOR_NAO_ENCONTRADO);

        Professor entity = modelMapper.map(dto, Professor.class);
        entity.setId(professor.getId());
        entity.setStatus(StatusEnum.INATIVO);
        entity.setDataAtualizacao(LocalDateTime.now());

        professorRepository.save(entity);
    }

}
