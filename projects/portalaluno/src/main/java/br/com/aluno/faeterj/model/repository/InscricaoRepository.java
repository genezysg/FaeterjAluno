package br.com.aluno.faeterj.model.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.aluno.faeterj.model.entity.Inscricao;


public interface InscricaoRepository extends CrudRepository<Inscricao, Long>{
	
	Inscricao findOne(Long arg);

}