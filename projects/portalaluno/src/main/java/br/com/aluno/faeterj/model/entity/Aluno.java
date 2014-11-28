package br.com.aluno.faeterj.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long id;
	  private String nome;
	  private String matricula;
	  private String email;
	  
	    

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
