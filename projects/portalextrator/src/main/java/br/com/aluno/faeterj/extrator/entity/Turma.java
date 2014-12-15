package br.com.aluno.faeterj.extrator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "viewturma")

public class Turma {
	@Id
	@GeneratedValue
	private long idturma;
	private String sigladisciplina;
	private String turno;
	private String siglaperiodoletivo;
	
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
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getSiglaperiodoletivo() {
		return siglaperiodoletivo;
	}
	public void setSiglaperiodoletivo(String siglaperiodoletivo) {
		this.siglaperiodoletivo = siglaperiodoletivo;
	}
}