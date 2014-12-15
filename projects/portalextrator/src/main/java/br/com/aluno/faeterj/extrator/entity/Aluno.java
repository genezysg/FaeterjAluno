package br.com.aluno.faeterj.extrator.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "viewaluno")

public class Aluno implements Serializable{
	@Id
	@GeneratedValue
	private long idpessoa;
	private String nome;
	private String matriculaaluno;
	private String email;

	public long getId() {
		return idpessoa;
	}

	public void setId(long idPessoa) {
		this.idpessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatriculaAluno() {
		return matriculaaluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaaluno = matriculaAluno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
