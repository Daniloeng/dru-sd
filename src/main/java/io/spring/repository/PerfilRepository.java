/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.entity.Perfil;

/**
 *
 * @author Projeto DRU de SD 2019
 */
public interface PerfilRepository extends MongoRepository<Perfil, String> {

    Perfil findByNome(String nome);

}
