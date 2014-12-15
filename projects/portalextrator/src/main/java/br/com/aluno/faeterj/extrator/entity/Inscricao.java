package br.com.aluno.faeterj.extrator.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Inscricao implements Serializable {

	@EmbeddedId
	InscricaoId id;
	private String situacaoinscricao;
	private Double mediafinal;
	private Integer totalfaltas;

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
}