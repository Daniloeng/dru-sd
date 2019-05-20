package io.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.entity.DRU;
import io.spring.repository.DRURepository;

@Service
public class DRUService {

	 @Autowired
	    DRURepository druRepository;
	 
	 public Page<DRU> listaPaginada(int count, int page) {
	        Pageable pages = new PageRequest(page, count);
	        return druRepository.findAll(pages);
	    }

	    public List<DRU> buscaPorNome(String nome) {
	        return druRepository.findByNomeLikeIgnoreCase(nome);
	    }

	    public DRU salvarDRU(DRU druAdd) {
	        return druRepository.save(druAdd);
	    }

	    public void deleteDRU(String id) {
	        druRepository.delete(id);
	    }

	    public DRU getById(String id) {
	        return druRepository.findOne(id);
	    }

		public List<DRU> listaDRU() {
			 return druRepository.findAll();
		}

}
