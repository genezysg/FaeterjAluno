package br.com.aluno.faeterj.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inscricao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idinscricao;
	private String situacaoinscricao;
	private double mediafinal;
	private int totalfaltas;

	@ManyToOne
	@JoinColumn(name = "idaluno", referencedColumnName = "idpessoa", nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "turmaid", referencedColumnName = "idturma", nullable = false)
	private Turma turma;

	public String getSituacaoInscricao() {
		return situacaoinscricao;
	}

	public void setSituacaoInscricao(String situacaoInscricao) {
		this.situacaoinscricao = situacaoInscricao;
	}

	public double getMediaFinal() {
		return mediafinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediafinal = mediaFinal;
	}

	public int getTotalFaltas() {
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
