package com.lbstecnologia.erp.app.services;

import com.lbstecnologia.erp.app.models.Aluno;
import com.lbstecnologia.erp.app.models.dtos.AlunoDTO;
import com.lbstecnologia.erp.app.repositories.AlunoRepository;
import com.lbstecnologia.erp.app.utils.ServiceAbstract;
import com.lbstecnologia.erp.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AlunoService extends ServiceAbstract<Aluno> {

    @Autowired
    private AlunoRepository alunoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Long inserir(AlunoDTO dto) {
        Aluno aluno = modelMapper.map(dto, Aluno.class);
        aluno.setId(null);
        aluno.setDataCriacao(LocalDateTime.now());
        aluno.setDataAtualizacao(LocalDateTime.now());

        aluno = alunoRepository.save(aluno);

        return aluno.getId();
    }

    @Transactional
    public void editar(Long id, AlunoDTO dto) {
        Aluno saved = buscarSaved(id);
        Aluno entity = modelMapper.map(dto, Aluno.class);
        entity.setId(saved.getId());
        entity.setDataCriacao(saved.getDataCriacao());
        entity.setDataAtualizacao(LocalDateTime.now());

        alunoRepository.save(entity);
    }

    public Aluno buscarSaved(Long id) {
        Aluno saved = alunoRepository.findById(id).orElse(null);
        verificaObjeto(saved, ObjectNotFoundException.ALUNO_NAO_ENCONTRADO);
        return saved;
    }

}
