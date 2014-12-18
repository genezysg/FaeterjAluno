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
    private Long matriculaaluno;

    @NotEmpty(message = "Nome é necessário.")
    private String nome;
	
	@NotEmpty(message = "Matrícula é necessária.")
	 private Long idpessoa;
	
    @Email(message = "Favor informar e-mail.")
    @NotEmpty(message = "E-mail é necessário.")
    @Column(unique=true, nullable = false)
    private String email;

    @NotEmpty(message = "Senha é necessária.")
    private String password;
	
	@OneToMany
	@JoinColumn(name="matriculaaluno")
	private Set<Inscricao> Inscricao;

    public Aluno() {}

    public Aluno(Aluno aluno) {
        this.idpessoa = aluno.idpessoa;
		this.matriculaaluno= aluno.matriculaaluno;
        this.nome = aluno.nome;
        this.email = aluno.email;
        this.password = aluno.password;
    }

	public Set<Inscricao> getInscricao() {
		return Inscricao;
	}


	public void setInscricao(Set<Inscricao> inscricao) {
		Inscricao = inscricao;
	}
	
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public Long getIdPessoa() {
        return idpessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idpessoa = idPessoa;
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
	
	public Long getMatriculaAluno() {
        return matriculaaluno;
    }

    public void setMatriculaAluno(Long matriculaAluno) {
        this.matriculaaluno = matriculaAluno;
    }
}
