package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifms.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
