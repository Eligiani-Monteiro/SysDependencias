package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Disciplina;

public class DisciplinaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeDisciplina;
	private String cargaHoraria;

	public DisciplinaDTO() {

	}

	public DisciplinaDTO(Long id, String nomeDisciplina, String cargaHoraria) {
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
	}

	public DisciplinaDTO(Disciplina entity) {
		this.id = entity.getId();
		this.nomeDisciplina = entity.getNomeDisciplina();
		this.cargaHoraria = entity.getCargaHoraria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
