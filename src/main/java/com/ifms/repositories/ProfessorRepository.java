package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifms.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
