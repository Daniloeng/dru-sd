/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.controller;

import io.spring.entity.Solicitacao;
import io.spring.service.SolicitacaoService;
import io.spring.utils.DateUtils;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SolicitacaoController {

    @Autowired
    SolicitacaoService solicitacaoService;


    @RequestMapping(value = "/solicitacao/{cpf}/cpf/", method = RequestMethod.GET)
    public List<Solicitacao> listarMinhasSolicitacoes(@PathVariable String cpf) {
        return this.solicitacaoService.listaSolicitacaoPorSolicitante(cpf) ;
    }

   
    
    
    

    @RequestMapping(value = "/solicitacao/{cpf}/novas/", method = RequestMethod.GET)
    public List<Solicitacao> listarSolicitacoesNovas(@PathVariable String cpf) {
        return this.solicitacaoService.listaSolicitacaoNovaPorSolicitado(cpf) ;
    }


    @RequestMapping(value = "/solicitacao/{cpf}/autorizadas/", method = RequestMethod.GET)
    public List<Solicitacao> listarSolicitacoesAprovadas(@PathVariable String cpf) {
        return this.solicitacaoService.listaSolicitacaoAutorizadaPorSolicitado(cpf) ;
    }


    @RequestMapping(value = "/solicitacao/{cpf}/negadas/", method = RequestMethod.GET)
    public List<Solicitacao> listarSolicitacoesNegadas(@PathVariable String cpf) {
        return this.solicitacaoService.listaSolicitacaoNegadaPorSolicitado(cpf) ;
    }
    

    
    @RequestMapping(value = "/solicitacao/aprovar/{id}/", method = RequestMethod.GET)
    public Solicitacao aprovarSolicitacao(@PathVariable String id) {
    	
       	DateUtils dateUtils = new DateUtils();
        Date atual = dateUtils.getDataAtual();
     	
    	Solicitacao solicitacao = solicitacaoService.getById(id);
    	solicitacao.setSituacao("AUTORIZADA");
    	solicitacao.setModificacaoEm(atual);
    	
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }

    

    @RequestMapping(value = "/solicitacao/negar/{id}/", method = RequestMethod.GET)
    public Solicitacao negarSolicitacao(@PathVariable String id) {
    	
       	DateUtils dateUtils = new DateUtils();
        Date atual = dateUtils.getDataAtual();
 
    	Solicitacao solicitacao = solicitacaoService.getById(id);
    	solicitacao.setSituacao("NEGADA");
    	solicitacao.setModificacaoEm(atual);
    	
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }

 
    

    @RequestMapping(value = "/solicitacao/criar/{solicitanteCpf}/{solicitanteNome}/{solicitanteEmail}/{solicitadoCpf}/{solicitadoNome}/{solicitadoEmail}/", method = RequestMethod.GET)
    public Solicitacao salvar( @PathVariable String solicitanteCpf,  @PathVariable String solicitanteNome,  @PathVariable String solicitanteEmail, 
    						   @PathVariable String solicitadoCpf, @PathVariable String solicitadoNome, @PathVariable String solicitadoEmail ) {
        
    	DateUtils dateUtils = new DateUtils();
        Date atual = dateUtils.getDataAtual();
        Date futuro = dateUtils.incrementaDataEmMeses(atual, 6);    
                
        
        Solicitacao solicitacao =  new Solicitacao();
    	
        solicitacao.setSolicitanteCpf(solicitanteCpf);
        solicitacao.setSolicitanteNome(solicitanteNome);
        solicitacao.setSolicitanteEmail(solicitanteEmail);
        
        solicitacao.setSolicitadoCpf(solicitadoCpf);
        solicitacao.setSolicitadoNome(solicitadoNome);
        solicitacao.setSolicitadoEmail(solicitadoEmail);
        
        solicitacao.setSolicitadoEm(atual);
        solicitacao.setModificacaoEm(atual);
        solicitacao.setExpiraEm(futuro);
        solicitacao.setSituacao("NOVA");
        solicitacao.setVisualizado("N");
        
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }


    
    
    
    @RequestMapping(value = "/solicitacao/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
    	Solicitacao solicitacao = solicitacaoService.getById(id);
        this.solicitacaoService.deletaSolicitacao(solicitacao);
    }

  

}
