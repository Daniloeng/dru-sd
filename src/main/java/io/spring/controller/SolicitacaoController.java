/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.controller;

import io.spring.entity.Solicitacao;
import io.spring.entity.Usuario;
import io.spring.repository.UsuarioRepository;
import io.spring.service.SolicitacaoService;
import io.spring.service.UsuarioService;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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


    @RequestMapping(value = "/solicitacao/{cpf}/aprovadas/", method = RequestMethod.GET)
    public List<Solicitacao> listarSolicitacoesAprovadas(@PathVariable String cpf) {
        return this.solicitacaoService.listaSolicitacaoAprovadaPorSolicitado(cpf) ;
    }


    @RequestMapping(value = "/solicitacao/{cpf}/negadas/", method = RequestMethod.GET)
    public List<Solicitacao> listarSolicitacoesNegadas(@PathVariable String cpf) {
        return this.solicitacaoService.listaSolicitacaoNegadaPorSolicitado(cpf) ;
    }

      
  
    
    

    
    @RequestMapping(value = "/solicitacao/{id}/aprovar/", method = RequestMethod.PUT)
    public Solicitacao aprovarSolicitacao(@PathVariable String id) {
    	Solicitacao solicitacao = solicitacaoService.getById(id);
    	solicitacao.setSituacao("APROVADA");
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }


    @RequestMapping(value = "/solicitacao/{id}/negar/", method = RequestMethod.PUT)
    public Solicitacao negarSolicitacao(@PathVariable String id) {
    	Solicitacao solicitacao = solicitacaoService.getById(id);
    	solicitacao.setSituacao("NEGADA");
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }

    
      
    @RequestMapping(value = "/solicitacao/{id}/marcar/", method = RequestMethod.PUT)
    public Solicitacao marcarComoVisualizada(@PathVariable String id) {
    	Solicitacao solicitacao = solicitacaoService.getById(id);
    	solicitacao.setVisualizado("S");
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }

    
    

    
   
    

    @RequestMapping(value = "/solicitacao", method = RequestMethod.POST)
    public Solicitacao salvar(@RequestBody Solicitacao solicitacao) {
        return this.solicitacaoService.salvaSolicitacao(solicitacao);
    }


    
    @RequestMapping(value = "/solicitacao/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.solicitacaoService.deletaSolicitacao(id);
    }

  

}
