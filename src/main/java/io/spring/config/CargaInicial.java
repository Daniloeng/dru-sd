/*
*
* Projeto DRU de SD 2019
*
*
 */
package io.spring.config;

import io.spring.entity.DRU;
import io.spring.entity.Perfil;
import io.spring.entity.Usuario;
import io.spring.repository.DRURepository;
import io.spring.repository.PerfilRepository;
import io.spring.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
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
            usuarioRepository.save(new Usuario("ADMIN", "admin", "123", novosPerfis));

        }
                       
        //Carga Inicial - DRU
        List<DRU> docUnicos = druRepository.findAll();
        
        if (docUnicos.isEmpty()) {
        	
            //Adicionar novos perfil para funcionalidades do DRU
            perfilRepository.save(new Perfil("ROLE_OWNER"));   //Proprietário de DRU
            perfilRepository.save(new Perfil("ROLE_THIRD"));   //Terceiros (Ex: Conveniados)        	    	       	
        	
        	//Criação de DRU
        	druRepository.save(new DRU("Gilson", "295.212.660-74", "CEP 12000-000", "gilsonsilva.cintra@gmail.com", "19992485023")); 
        	druRepository.save(new DRU("Danilo", "851.673.080-89", "CEP 12000-000", "daniloeng.ribeiro@gmail.com", "12982691615"));
        	druRepository.save(new DRU("Daniel", "154.571.120-80", "CEP 12000-000", "danisantosalves@gmail.com", "12991065737"));
        	druRepository.save(new DRU("Renan", "376.689.950-30", "CEP 12000-000", "renanru_zao@hotmail.com", "12XXXXXXXXX"));
        	druRepository.save(new DRU("João Lemos", "120.709.000-02", "CEP 12000-000", "joaojol@fab.mil.br", "12YYYYYYYYY"));

        	//Criação de usuários proprietários de DRU - Login igual o Email
            Perfil perfilOWNER = perfilRepository.findByNome("ROLE_OWNER");

            List<Perfil> novosPerfis = new ArrayList<>();
            
            novosPerfis.add(perfilOWNER);
        	
        	usuarioRepository.save(new Usuario("gilsonsilva.cintra@gmail.com", "gilsonsilva.cintra@gmail.com", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("daniloeng.ribeiro@gmail.com", "daniloeng.ribeiro@gmail.com", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("danisantosalves@gmail.com", "danisantosalves@gmail.com", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("renanru_zao@hotmail.com", "renanru_zao@hotmail.com", "123", novosPerfis));
        	usuarioRepository.save(new Usuario("joaojol@fab.mil.br", "joaojol@fab.mil.br", "123", novosPerfis));        	           
        }

    }

}
