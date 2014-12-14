package br.com.aluno.faeterj.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long matriculaaluno;
	  private long idpessoa;
	  private String nome;
	  private String email;


		@OneToMany
		@JoinColumn(name="matriculaaluno")
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


		public Long getMatriculaaluno() {
			return matriculaaluno;
		}


		public void setMatriculaaluno(Long matriculaaluno) {
			this.matriculaaluno = matriculaaluno;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		
	  
	 
		
}
