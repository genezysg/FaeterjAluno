package br.com.aluno.faeterj.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.aluno.faeterj.model.entity.Aluno;
import br.com.aluno.faeterj.model.entity.Turma;

public interface AlunoRepository extends CrudRepository<Aluno, Long>{

	Aluno findOne(Long arg);
	
}
