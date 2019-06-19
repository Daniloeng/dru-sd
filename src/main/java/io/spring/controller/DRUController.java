package io.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.entity.DRU;
import io.spring.service.DRUService;

@RestController
public class DRUController {

	@Autowired
    DRUService druService;

    @RequestMapping(value = "/dru", method = RequestMethod.GET)
    public List<DRU> listar() {
        return this.druService.listaDRU();
    }
 
    
    @RequestMapping(value = "/dru/{id}", method = RequestMethod.GET)
    public DRU getById(@PathVariable String id) {
       System.out.println("Aqui");
    	return this.druService.getById(id);
    }
    
    @RequestMapping(value = "/dru/{cpf}/cpf", method = RequestMethod.GET)
    public DRU getByCpf(@PathVariable String cpf) {
    	System.out.println("CPF: " + cpf);
    	return this.druService.getByCpf(cpf);
    }    
    
    @RequestMapping(value = "/dru/{email}/email", method = RequestMethod.GET)
    public DRU getByEmail(@PathVariable String email) {
    	System.out.println("E-mail: " + email);
    	return this.druService.getByEmail(email);
    }

    @RequestMapping(value = "/dru/{page}/{count}", method = RequestMethod.GET)
    public Page<DRU> listaPaginada(@PathVariable int page, @PathVariable int count) {
    	return this.druService.listaPaginada(count, page);
    }

    @RequestMapping(value = "/dru", method = RequestMethod.POST)
    public DRU salvar(@RequestBody DRU dru) {
    	return this.druService.salvarDRU(dru);
    }

    @RequestMapping(value = "/dru", method = RequestMethod.PUT)
    public DRU editar(@RequestBody DRU dru) {
    	return this.druService.salvarDRU(dru);
    }

    @RequestMapping(value = "/dru/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
    	this.druService.deleteDRU(id);
    }

}
