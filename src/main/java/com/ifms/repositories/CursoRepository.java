package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifms.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
