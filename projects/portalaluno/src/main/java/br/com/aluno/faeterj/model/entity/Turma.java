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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long idturma;
	  private String sigladisciplina;
	  private String siglaperiodoletivo;
	  private String turno;
	  
	  
		@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
		private Set<Inscricao> Inscricao;


		public long getIdturma() {
			return idturma;
		}


		public void setIdturma(long idturma) {
			this.idturma = idturma;
		}


		public String getSigladisciplina() {
			return sigladisciplina;
		}


		public void setSigladisciplina(String sigladisciplina) {
			this.sigladisciplina = sigladisciplina;
		}


		public String getSiglaperiodoletivo() {
			return siglaperiodoletivo;
		}


		public void setSiglaperiodoletivo(String siglaperiodoletivo) {
			this.siglaperiodoletivo = siglaperiodoletivo;
		}


		public Set<Inscricao> getInscricao() {
			return Inscricao;
		}


		public void setInscricao(Set<Inscricao> inscricao) {
			Inscricao = inscricao;
		}
		
	  
}