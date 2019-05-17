/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.entity.Usuario;

/**
 *
 * @author Projeto DRU de SD 2019
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
    Usuario findByEmail(String email);
}
