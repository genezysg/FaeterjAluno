package br.com.aluno.faeterj.extrator;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Inscricao {

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
}