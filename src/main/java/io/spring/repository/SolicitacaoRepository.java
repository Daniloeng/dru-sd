/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


import io.spring.entity.Solicitacao;



public interface SolicitacaoRepository extends MongoRepository<Solicitacao, String> {

    List<Solicitacao> findBySolicitante(String solicitante);
    List<Solicitacao> findBySolicitado(String solicitado);
    
    List<Solicitacao> findBySolicitadoAndSituacaoOrderBySolicitadoEmDesc(String solicitado, String situacao);


    
}
