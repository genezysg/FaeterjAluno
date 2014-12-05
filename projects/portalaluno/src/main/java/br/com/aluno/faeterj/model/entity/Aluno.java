package br.com.aluno.faeterj.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long id;
	  private String nome;
	  private String matricula;
	  private String email;
	  
	  
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(name = "aluno_turma",joinColumns = { 
				@JoinColumn(name = "id") }, 
				inverseJoinColumns = { @JoinColumn(name = "turmaid") })
	 private Set<Turma> turmas;
	  public Set<Turma> geturmas() {
			return this.turmas;
			
		}
	 
		public void setTurmas(Set<Turma> turmas) {
			this.turmas = turmas;
		}
	  
	    

		public long getId() {
			return id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
}
