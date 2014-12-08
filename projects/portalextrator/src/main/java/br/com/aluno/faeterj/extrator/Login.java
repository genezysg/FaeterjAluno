package br.com.aluno.faeterj.extrator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	private long idpessoa;
	private String nomeacesso;
	private String senha;

	public long getId() {
		return idpessoa;
	}

	public void setId(long idPessoa) {
		this.idpessoa = idPessoa;
	}

	public String getNomeAcesso() {
		return nomeacesso;
	}

	public void setNomeAcesso(String nomeAcesso) {
		this.nomeacesso = nomeAcesso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
