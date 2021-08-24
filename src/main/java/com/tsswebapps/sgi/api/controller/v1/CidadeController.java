package com.tsswebapps.sgi.api.controller.v1;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.sgi.domain.exception.CidadeNaoEncontradoException;
import com.tsswebapps.sgi.domain.exception.NegocioException;
import com.tsswebapps.sgi.domain.model.Cidade;
import com.tsswebapps.sgi.domain.service.CidadeService;

@RestController
@RequestMapping(path = "v1/cidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Cidade> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Cidade buscar(@PathVariable Long id) {
		return service.buscarOuFalhar(id);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cidade salvar(@RequestBody Cidade estado) {
		return service.salvar(estado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Cidade atualizar(@PathVariable Long id, @RequestBody Cidade cidadeAlterada) {
		Cidade cidadeAtual = service.buscarOuFalhar(id);
		BeanUtils.copyProperties(cidadeAlterada, cidadeAtual, "id");
		return service.salvar(cidadeAtual);
	}

	
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		try {
			service.excluir(id);
		} catch (CidadeNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
}
