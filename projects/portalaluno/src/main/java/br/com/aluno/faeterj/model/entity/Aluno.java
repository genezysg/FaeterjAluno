package br.com.aluno.faeterj.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPessoa;

    @NotEmpty(message = "Nome é necessário.")
    private String nome;
	
	@NotEmpty(message = "Matrícula é necessária.")
	private Long matriculaAluno;
	
    @Email(message = "Favor informar e-mail.")
    @NotEmpty(message = "E-mail é necessário.")
    @Column(unique=true, nullable = false)
    private String email;

    @NotEmpty(message = "Senha é necessária.")
    private String senha;
	
	@OneToMany
	@JoinColumn(name="matriculaaluno")
	private Set<Inscricao> Inscricao;

    public Aluno() {}

    public Aluno(Aluno aluno) {
        this.idPessoa = aluno.idPessoa;
		this.matriculaAluno= aluno.matriculaAluno;
        this.nome = aluno.nome;
        this.email = aluno.email;
        this.senha = aluno.senha;
    }

	public Set<Inscricao> getInscricao() {
		return Inscricao;
	}


	public void setInscricao(Set<Inscricao> inscricao) {
		Inscricao = inscricao;
	}
	
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
    	this.senha = senha;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
	public Long getMatriculaAluno(Long matriculaAluno) {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Long matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }
}
