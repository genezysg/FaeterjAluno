package br.com.aluno.faeterj.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turma {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long turmaid;
	  
	  @ManyToOne 
	  @JoinColumn(name="id", referencedColumnName = "disciplinaid", nullable = false)
	  private Disciplina disciplina;
	  private String ano;
	 
	  
	public long getId() {
		return turmaid;
	}
	public void setId(long id) {
		this.turmaid = id;
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

}