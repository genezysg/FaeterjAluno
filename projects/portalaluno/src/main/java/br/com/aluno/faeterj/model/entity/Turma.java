package br.com.aluno.faeterj.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long id;
	  private String ano;
	  private Disciplina disciplina;
	  private int totalFaltas;
	  private int totalPresença;
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public int getTotalFaltas() {
		return totalFaltas;
	}
	public void setTotalFaltas(int totalFaltas) {
		this.totalFaltas = totalFaltas;
	}
	public int getTotalPresença() {
		return totalPresença;
	}
	public void setTotalPresença(int totalPresença) {
		this.totalPresença = totalPresença;
	}
}