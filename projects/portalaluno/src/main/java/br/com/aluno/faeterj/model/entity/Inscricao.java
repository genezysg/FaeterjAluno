package br.com.aluno.faeterj.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inscricao {

	@EmbeddedId
	InscricaoId id;
	private String situacaoinscricao;
	private Double mediafinal;
	private Integer totalfaltas;
	
	
	public Inscricao(Aluno aluno,Turma turma)
	{
		id= new InscricaoId(aluno,turma);
	}
	
	public Inscricao(){};
    @ManyToOne
    @JoinColumn(name="idturma", referencedColumnName="idturma",insertable =  false, updatable = false)
    public Turma turma;
    
    @ManyToOne
    @JoinColumn(name="matriculaaluno", referencedColumnName="matriculaaluno",insertable =  false, updatable = false)
    public Aluno aluno;
    
    
	public String getSituacaoInscricao() {
		return situacaoinscricao;
	}

	public void setSituacaoInscricao(String situacaoInscricao) {
		this.situacaoinscricao = situacaoInscricao;
	}

	public Double getMediaFinal() {
		return mediafinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediafinal = mediaFinal;
	}

	public Integer getTotalFaltas() {
		return totalfaltas;
	}

	public void setTotalFaltas(int totalFaltas) {
		this.totalfaltas = totalFaltas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
