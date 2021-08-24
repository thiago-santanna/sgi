package com.tsswebapps.sgi.api.controller.v1;

import java.util.List;

import javax.validation.Valid;

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

import com.tsswebapps.sgi.domain.exception.NegocioException;
import com.tsswebapps.sgi.domain.exception.PaisNaoEncontradoException;
import com.tsswebapps.sgi.domain.model.Pais;
import com.tsswebapps.sgi.domain.service.PaisService;

@RestController
@RequestMapping(path = "v1/pais", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaisController {
	
	@Autowired
	private PaisService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pais> listar(){
		return service.listar();
	}
	
	@GetMapping("/{paisId}")
	public Pais buscar(@PathVariable Long paisId) {
		return service.buscarOuFalhar(paisId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pais adicionar(@RequestBody @Valid Pais pais) {
		return service.salvar(pais);
	}
	
	@PutMapping(path = "/{paisId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Pais atualizar(@PathVariable Long paisId, @RequestBody Pais pais){
		Pais paisEncontrado = service.buscarOuFalhar(paisId);
		
		BeanUtils.copyProperties(pais, paisEncontrado, "id");
		return service.salvar(paisEncontrado);
	}
	
	@DeleteMapping("/{paisId}")
	public void apagar(@PathVariable Long paisId) {
		try {
			service.excluir(paisId);
		}
		catch (PaisNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
