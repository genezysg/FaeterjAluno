package br.com.aluno.faeterj.extrator.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InscricaoId implements Serializable{
    int idturma;
    long matriculaaluno;
	public int getIdturma() {
		return idturma;
	}
	public void setIdturma(int idturma) {
		this.idturma = idturma;
	}
	public long getMatriculaaluno() {
		return matriculaaluno;
	}
	public void setMatriculaaluno(long matriculaaluno) {
		this.matriculaaluno = matriculaaluno;
	}
}