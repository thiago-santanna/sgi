package com.tsswebapps.sgi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.sgi.domain.model.Pais;
import com.tsswebapps.sgi.domain.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository repository;
	
	public List<Pais> listar(){
		return repository.findAll();
	}
	
	public Pais buscar(Long id) {
		return repository.findById(id).get();
	}
	
	public Pais salvar(Pais pais) {
		return repository.save(pais);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}

}
