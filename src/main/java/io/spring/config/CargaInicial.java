/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.config;

import io.spring.entity.DRU;
import io.spring.entity.Perfil;
import io.spring.entity.Solicitacao;
import io.spring.entity.Usuario;
import io.spring.repository.DRURepository;
import io.spring.repository.PerfilRepository;
import io.spring.repository.SolicitacaoRepository;
import io.spring.repository.UsuarioRepository;
import io.spring.utils.DateUtils;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Projeto DRU de SD 2019
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    DRURepository druRepository;

    @Autowired
    PerfilRepository perfilRepository;
    
    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

    	//Carga Inicial - Usuario
        List<Perfil> perfis = perfilRepository.findAll();

        if (perfis.isEmpty()) {
        	
            perfilRepository.save(new Perfil("ROLE_ADMIN"));   //Administrador

            Perfil perfilADMIN = perfilRepository.findByNome("ROLE_ADMIN");

            List<Perfil> novosPerfis = new ArrayList<>();

            novosPerfis.add(perfilADMIN);

            //Criação do usuário Administrador
            usuarioRepository.save(new Usuario("ADMIN", "admin", "0", "123", novosPerfis));

        }
                       
        //Carga Inicial - DRU
        List<DRU> docUnicos = druRepository.findAll();
        
        if (docUnicos.isEmpty()) {
        	
            //Adicionar novos perfil para funcionalidades do DRU
            perfilRepository.save(new Perfil("ROLE_OWNER"));   //Proprietário de DRU
            perfilRepository.save(new Perfil("ROLE_THIRD"));   //Terceiros (Ex: Conveniados)        	    	       	
        	
        	//Criação de DRU
        	druRepository.save(new DRU("Gilson", "295.212.660-74", "CEP 12000-000", "gilsonsilva.cintra@gmail.com", "19992485023", "São José dos Campos", "SP", "M")); 
        	druRepository.save(new DRU("Danilo", "851.673.080-89", "CEP 12000-000", "daniloeng.ribeiro@gmail.com", "12982691615", "São José dos Campos", "SP", "M"));
        	druRepository.save(new DRU("Daniel", "154.571.120-80", "CEP 12000-000", "danisantosalves@gmail.com", "12991065737", "São José dos Campos", "SP", "M"));
        	druRepository.save(new DRU("Renan", "376.689.950-30", "CEP 12000-000", "renanru_zao@hotmail.com", "12XXXXXXXXX", "São José dos Campos", "SP", "M"));
        	druRepository.save(new DRU("João Lemos", "120.709.000-02", "CEP 12000-000", "joaojol@fab.mil.br", "12YYYYYYYYY", "São José dos Campos", "SP", "M"));
        	druRepository.save(new DRU("José Renato", "799.458.970-71", "CEP 12000-000", "renatojrna@fab.mil.br", "12YYYYYYYYY", "São José dos Campos", "SP", "M"));

        	//Criação de usuários proprietários de DRU - Login igual o Email
            Perfil perfilOWNER = perfilRepository.findByNome("ROLE_OWNER");
            Perfil perfilTHIRD = perfilRepository.findByNome("ROLE_THIRD");

            List<Perfil> novosPerfis = new ArrayList<>();
            
            novosPerfis.add(perfilOWNER);

            usuarioRepository.save(new Usuario("gilsonsilva.cintra@gmail.com", "gilsonsilva.cintra@gmail.com", "295.212.660-74", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("daniloeng.ribeiro@gmail.com", "daniloeng.ribeiro@gmail.com", "851.673.080-89", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("danisantosalves@gmail.com", "danisantosalves@gmail.com", "154.571.120-80", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("renanru_zao@hotmail.com", "renanru_zao@hotmail.com", "376.689.950-30", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("joaojol@fab.mil.br", "joaojol@fab.mil.br", "120.709.000-02", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("renatojrna@fab.mil.br", "renatojrna@fab.mil.br", "799.458.970-71", "123", novosPerfis));
        	
        	
        	novosPerfis.clear();
        	novosPerfis.add(perfilTHIRD);
        	
        	usuarioRepository.save(new Usuario("testeautomatizadosd@gmail.com", "testeautomatizadosd@gmail.com", "415.489.470-67", "123", novosPerfis));
	    	usuarioRepository.save(new Usuario("testeautomatizadosd1@gmail.com", "testeautomatizadosd1@gmail.com", "417.645.300-12", "123", novosPerfis));	    	
	    	
        }
        
        
        
        
        List <Solicitacao> solicitacoes = solicitacaoRepository.findAll();

        if (solicitacoes.isEmpty()) {
        
	        DateUtils dateUtils = new DateUtils();
	        Date atual = dateUtils.getDataAtual();
	        Date futuro = dateUtils.incrementaDataEmMeses(atual, 6);
	        
		       
	        solicitacaoRepository.save(new Solicitacao("295.212.660-74", "851.673.080-89", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("295.212.660-74", "154.571.120-80", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("295.212.660-74", "376.689.950-30", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("295.212.660-74", "120.709.000-02", "NOVA", "N", atual, futuro, atual));   
		       
	        
	        solicitacaoRepository.save(new Solicitacao("851.673.080-89", "120.709.000-02", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("851.673.080-89", "154.571.120-80", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("851.673.080-89", "376.689.950-30", "NOVA", "N", atual, futuro, atual));   
	        
		       
	        solicitacaoRepository.save(new Solicitacao("376.689.950-30", "851.673.080-89", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("376.689.950-30", "154.571.120-80", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("376.689.950-30", "295.212.660-74", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("376.689.950-30", "120.709.000-02", "NOVA", "N", atual, futuro, atual));   
	        solicitacaoRepository.save(new Solicitacao("376.689.950-30", "799.458.970-71", "NOVA", "N", atual, futuro, atual));           
	   
        }
        
        
    }

}
