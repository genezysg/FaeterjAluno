package br.com.aluno.faeterj.extrator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "viewturma")

public class Turma {
	@Id
	@GeneratedValue
	private long idturma;
	private String nome;
	private String matricula;
	private String email;
}