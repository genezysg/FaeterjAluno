package br.com.aluno.faeterj.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long disciplinaid;
	
	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private Set<Turma> Turma;
	private String nome;

	private String professor;
	private int cargaHoraria;

	public long getId() {
		return disciplinaid;
	}

	public void setId(long id) {
		this.disciplinaid = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Set<Turma> getTurma() {
		return Turma;
	}

	public void setTurma(Set<Turma> turma) {
		Turma = turma;
	}
}
