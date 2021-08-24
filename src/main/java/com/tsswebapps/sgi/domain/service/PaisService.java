package com.tsswebapps.sgi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tsswebapps.sgi.domain.exception.EntidadeEmUsoException;
import com.tsswebapps.sgi.domain.exception.PaisNaoEncontradoException;
import com.tsswebapps.sgi.domain.model.Pais;
import com.tsswebapps.sgi.domain.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository repository;
	
	public List<Pais> listar(){
		return repository.findAll();
	}
	
	public Optional<Pais> buscar(Long id) {
		return repository.findById(id);				
	}
	
	public Pais buscarOuFalhar(Long id) {
		return repository.findById(id)
				.orElseThrow(
						() -> new PaisNaoEncontradoException(String.format("País não encontrado %d", id)));		
	}
	
	public Pais salvar(Pais pais) {
		return repository.save(pais);
	}
	
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		}
		catch (EmptyResultDataAccessException e) {
			throw new PaisNaoEncontradoException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("O Páis, %d não pode ser removido, existem dependencias a ele.", id));
		}
	}

}
