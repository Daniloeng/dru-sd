package io.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.entity.DRU;

public interface DRURepository extends MongoRepository<DRU, String> {

    List<DRU> findByNomeLikeIgnoreCase(String nome);
    
    DRU findByEmail(String email);

}