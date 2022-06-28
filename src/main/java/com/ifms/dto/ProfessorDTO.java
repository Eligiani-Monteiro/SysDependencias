package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Professor;

public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeProfessor;
	private String titulo;

	public ProfessorDTO() {

	}

	public ProfessorDTO(Long id, String nomeProfessor, String titulo) {
		this.id = id;
		this.nomeProfessor = nomeProfessor;
		this.titulo = titulo;
	}

	public ProfessorDTO(Professor entity) {
		this.id = entity.getId();
		this.nomeProfessor = entity.getNomeProfessor();
		this.titulo = entity.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
