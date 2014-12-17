package br.com.aluno.faeterj.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.aluno.faeterj.model.entity.User;

/**
 * Allows managing {@link User} instances.
 *
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}