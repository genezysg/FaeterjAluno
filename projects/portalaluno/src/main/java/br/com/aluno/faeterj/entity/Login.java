package br.com.aluno.faeterj.entity;

public class Login {
	
	private String matricula;
	String senha;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean Autentica()
	{
		if(matricula.equals("123") && senha.equals("456"))
			return true;
		return false;
	}

}
