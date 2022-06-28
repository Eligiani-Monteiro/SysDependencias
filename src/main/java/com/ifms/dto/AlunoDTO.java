package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nomeAluno;
	private String idade;
	private String raAluno;
	private String matricula;

	public AlunoDTO() {

	}

	public AlunoDTO(Long id, String nomeAluno, String idade, String raAluno, String matricula) {
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.idade = idade;
		this.raAluno = raAluno;
		this.matricula = matricula;
	}

	public AlunoDTO(Aluno entity) {
		this.id = entity.getId();
		this.nomeAluno = entity.getNomeAluno();
		this.idade = entity.getIdade();
		this.raAluno = entity.getRaAluno();
		this.matricula = entity.getMatricula();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getRaAluno() {
		return raAluno;
	}

	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
