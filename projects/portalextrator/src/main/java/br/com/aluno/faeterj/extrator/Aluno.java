package br.com.aluno.faeterj.extrator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "viewaluno")

public class Aluno {
	@Id
	@GeneratedValue
	private long idpessoa;
	private String nome;
	private String matricula;
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
		return matricula;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matricula = matriculaAluno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
