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
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long idpessoa;
	  private String nome;
	  private String matriculaaluno;
	  private String email;
	  

		@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
		private Set<Inscricao> Inscricao;
		
		public Set<Inscricao> getInscricao() {
			return Inscricao;
		}


		public void setInscricao(Set<Inscricao> inscricao) {
			Inscricao = inscricao;
		}


		public long getIdpessoa() {
			return idpessoa;
		}


		public void setIdpessoa(long idpessoa) {
			this.idpessoa = idpessoa;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getMatriculaaluno() {
			return matriculaaluno;
		}


		public void setMatriculaaluno(String matriculaaluno) {
			this.matriculaaluno = matriculaaluno;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		
	  
	 
		
}
