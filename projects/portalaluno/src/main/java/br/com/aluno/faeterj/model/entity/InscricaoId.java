package br.com.aluno.faeterj.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InscricaoId implements Serializable{
    Long idturma;
    long matriculaaluno;
    
    public InscricaoId(Aluno aluno,Turma turma)
    {
    	matriculaaluno=aluno.getMatriculaaluno();
    	idturma=turma.getIdturma();
    }
    
    public InscricaoId(){};
    
    
	public Long getIdturma() {
		return idturma;
	}
	public void setIdturma(Long idturma) {
		this.idturma = idturma;
	}
	public long getMatriculaaluno() {
		return matriculaaluno;
	}
	public void setMatriculaaluno(long matriculaaluno) {
		this.matriculaaluno = matriculaaluno;
	}
}