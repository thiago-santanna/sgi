package com.tsswebapps.sgi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tsswebapps.sgi.domain.exception.CidadeNaoEncontradoException;
import com.tsswebapps.sgi.domain.exception.EntidadeEmUsoException;
import com.tsswebapps.sgi.domain.exception.EntidadeNaoEncontradaException;
import com.tsswebapps.sgi.domain.model.Cidade;
import com.tsswebapps.sgi.domain.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> listar() {
		return repository.findAll();
	}
	
	public Optional<Cidade> buscar(Long id) {
		return repository.findById(id);
	}
	
	public Cidade buscarOuFalhar(Long id) {
		return repository.findById(id).orElseThrow( 
					() -> new EntidadeNaoEncontradaException(String.format("Cidade não encontrada %d", id))
				);
	}
	
	public Cidade salvar(Cidade estado) {
		return repository.save(estado);
	}
	
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradoException(id);
		}
		catch(DataIntegrityViolationException e){
			throw new EntidadeEmUsoException("Não é possível apagar uma cidade em uso");
		}
	}
}
