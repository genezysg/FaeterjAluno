package br.com.aluno.faeterj.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.aluno.faeterj.model.entity.Turma;


	public interface TurmaRepository extends CrudRepository<Turma, Long>{
		
		Turma findOne(Long arg);

}
