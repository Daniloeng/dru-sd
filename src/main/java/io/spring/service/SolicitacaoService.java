/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.service;

import io.spring.entity.Solicitacao;
import io.spring.repository.SolicitacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    
    public List<Solicitacao> listaSolicitacaoPorSolicitante(String solicitante) {
        return solicitacaoRepository.findBySolicitanteOrderBySolicitadoEmDesc(solicitante);
    }

  
    
    
    
    public List<Solicitacao> listaSolicitacaoNovaPorSolicitado(String solicitado) {
        return solicitacaoRepository.findBySolicitadoAndSituacaoOrderBySolicitadoEmDesc(solicitado, "NOVA");
    }
 
    
    public List<Solicitacao> listaSolicitacaoAprovadaPorSolicitado(String solicitado) {
        return solicitacaoRepository.findBySolicitadoAndSituacaoOrderBySolicitadoEmDesc(solicitado, "APROVADA");
    }
    

    
    public List<Solicitacao> listaSolicitacaoNegadaPorSolicitado(String solicitado) {
        return solicitacaoRepository.findBySolicitadoAndSituacaoOrderBySolicitadoEmDesc(solicitado, "NEGADA");
    }
        
        

     
    
    public Solicitacao salvaSolicitacao(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

 
    public void deletaSolicitacao(String id) {
    	solicitacaoRepository.delete(id);
    }
      
    

    public Solicitacao getById(String id) {
        return solicitacaoRepository.findOne(id);
    }
    
    

    
//
//    public void aprovarSolicitacao(String id) {
//    	solicitacaoRepository.aprovarSolicitacao(id);
//    }
//  
//
//    public void negarSolicitacao(String id) {
//    	solicitacaoRepository.negarSolicitacao(id);
//    }
//    
//
//    public void marcarComoVisualizada(String id) {
//    	solicitacaoRepository.marcarComoVisualizada(id);
//    }
//  
    
  
    

}
