package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Curso;

public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nomeCurso;
	private String turno;

	public CursoDTO() {

	}

	public CursoDTO(Long id, String nomeCurso, String turno) {
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.turno = turno;
	}

	public CursoDTO(Curso entity) {
		this.id = entity.getId();
		this.nomeCurso = entity.getNomeCurso();
		this.turno = entity.getTurno();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}
