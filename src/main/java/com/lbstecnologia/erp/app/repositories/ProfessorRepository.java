package com.lbstecnologia.erp.app.repositories;

import com.lbstecnologia.erp.app.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
