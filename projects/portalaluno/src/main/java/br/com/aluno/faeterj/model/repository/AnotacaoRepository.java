package br.com.aluno.faeterj.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.aluno.faeterj.model.entity.Anotacao;


public interface AnotacaoRepository extends CrudRepository<Anotacao, Long>{
		
	Iterable<Anotacao> findAll();
}
