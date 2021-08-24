package com.tsswebapps.sgi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tsswebapps.sgi.domain.exception.EntidadeEmUsoException;
import com.tsswebapps.sgi.domain.exception.EntidadeNaoEncontradaException;
import com.tsswebapps.sgi.domain.exception.EstadoNaoEncontradoException;
import com.tsswebapps.sgi.domain.model.Estado;
import com.tsswebapps.sgi.domain.repository.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> listar() {
		return repository.findAll();
	}
	
	public Optional<Estado> buscar(Long id) {
		return repository.findById(id);
	}
	
	public Estado buscarOuFalhar(Long id) {
		return repository.findById(id).orElseThrow( 
					() -> new EntidadeNaoEncontradaException(String.format("Estado não encontrado %d", id))
				);
	}
	
	public Estado salvar(Estado estado) {
		return repository.save(estado);
	}
	
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(id);
		}
		catch(DataIntegrityViolationException e){
			throw new EntidadeEmUsoException("Não é possível apagar um estado em uso");
		}
	}
}
