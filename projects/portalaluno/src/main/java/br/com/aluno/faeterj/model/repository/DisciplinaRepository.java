package br.com.aluno.faeterj.model.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.aluno.faeterj.model.entity.Disciplina;


public interface DisciplinaRepository extends CrudRepository<Disciplina, Long>{
	
	Disciplina findOne(Long arg);

}