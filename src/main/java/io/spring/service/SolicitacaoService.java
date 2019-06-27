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
import org.springframework.stereotype.Service;


@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    
    public List<Solicitacao> listaSolicitacaoPorSolicitante(String solicitanteCpf) {
        return solicitacaoRepository.findBySolicitanteCpfOrderBySolicitadoEmDesc(solicitanteCpf);
    }

  
    
    
    
    public List<Solicitacao> listaSolicitacaoNovaPorSolicitado(String solicitadoCpf) {
        return solicitacaoRepository.findBySolicitadoCpfAndSituacaoOrderBySolicitadoEmDesc(solicitadoCpf, "NOVA");
    }
 
    
    public List<Solicitacao> listaSolicitacaoAutorizadaPorSolicitado(String solicitadoCpf) {
        return solicitacaoRepository.findBySolicitadoCpfAndSituacaoOrderBySolicitadoEmDesc(solicitadoCpf, "AUTORIZADA");
    }
    

    
    public List<Solicitacao> listaSolicitacaoNegadaPorSolicitado(String solicitadoCpf) {
        return solicitacaoRepository.findBySolicitadoCpfAndSituacaoOrderBySolicitadoEmDesc(solicitadoCpf, "NEGADA");
    }
        
        

     
    
    public Solicitacao salvaSolicitacao(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

 
    public void deletaSolicitacao(String id) {
    	solicitacaoRepository.delete(id);
    }
      
    

    public Solicitacao getById(String id) {
        return solicitacaoRepository.findById(id);
    }
    


}
