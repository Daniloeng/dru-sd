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

    List<Solicitacao> findBySolicitanteCpf(String solicitanteCpf);
    List<Solicitacao> findBySolicitadoCpf(String solicitadoCpf);
    
    List<Solicitacao> findBySolicitanteCpfOrderBySolicitadoEmDesc(String solicitanteCpf);
    List<Solicitacao> findBySolicitadoCpfOrderBySolicitadoEmDesc(String solicitadoCpf);
    
    List<Solicitacao> findBySolicitadoCpfAndSituacaoOrderBySolicitadoEmDesc(String solicitadoCpf, String situacao);

   
}
