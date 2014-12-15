package br.com.aluno.faeterj.extrator.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import br.com.aluno.faeterj.extrator.entity.Aluno;
import br.com.aluno.faeterj.extrator.entity.Inscricao;
import br.com.aluno.faeterj.extrator.entity.Turma;

@EnableJpaRepositories
@Service
public class Carga implements Serializable{

	List<Aluno> alunos = new ArrayList<>();
	List<Inscricao> inscricoes= new ArrayList<>();
	List<Turma> turmas= new ArrayList<>();
	
	
	
	
	
	public  boolean setAluno(Iterable<Aluno> alunos)
	{
	for(Aluno a:alunos)
		this.alunos.add(a);
	return true;
	}
	public  boolean setInscricao(Iterable<Inscricao> inscricoes)
	{
		for(Inscricao i:inscricoes)
			this.inscricoes.add(i);
		return true;
	}
	public  boolean setTurma(Iterable<Turma> turmas)
	{
		for(Turma t:turmas)
		this.turmas.add(t);
		return true;
	}
	public void save() {
	try
	{
		 OutputStream file = new FileOutputStream("carga.dat");
	     OutputStream buffer = new BufferedOutputStream(file);
	     ObjectOutput output = new ObjectOutputStream(buffer);
	     output.writeObject(this);
	     output.close();
	}
	
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	}
}

