package io.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.entity.DRU;
import io.spring.entity.Perfil;

public interface DRURepository extends MongoRepository<DRU, String> {

    List<DRU> findByNomeLikeIgnoreCase(String nome);
       
    DRU findByEmail(String email);
    
    DRU findByNome(String nome);

}