package com.tsswebapps.sgi.api.controller.v1;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsswebapps.sgi.domain.exception.EstadoNaoEncontradoException;
import com.tsswebapps.sgi.domain.exception.NegocioException;
import com.tsswebapps.sgi.domain.model.Estado;
import com.tsswebapps.sgi.domain.service.EstadoService;

@RestController
@RequestMapping(path = "v1/estado", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Estado> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Estado buscar(@PathVariable Long id) {
		return service.buscarOuFalhar(id);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {
		return service.salvar(estado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Estado atualizar(@PathVariable Long id, @RequestBody Estado estadoAlterado) {
		Estado estadoAtual = service.buscarOuFalhar(id);
		BeanUtils.copyProperties(estadoAlterado, estadoAtual, "id", "pais");
		return service.salvar(estadoAtual);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Estado atualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos){
		Estado estadoAtual = service.buscarOuFalhar(id);
		
		merge(campos, estadoAtual);
		
		return atualizar(id, estadoAtual);
	}

	private void merge(Map<String, Object> campos, Estado estadoDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Estado estadoOriginal = objectMapper.convertValue(campos, Estado.class);
		
		campos.forEach((chave, valor) -> {
			Field field = ReflectionUtils.findField(Estado.class, chave);
			field.setAccessible(true);					
			Object novoValor = ReflectionUtils.getField(field, estadoOriginal);			
			ReflectionUtils.setField(field, estadoDestino, novoValor);
		});
	}
	
	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		try {
			service.excluir(id);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
}
