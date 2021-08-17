package com.tsswebapps.sgi.api.controller.v1;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Pais> buscar(@PathVariable Long paisId) {
		Pais paisEncontrado = service.buscar(paisId);
		
		if(paisEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(paisEncontrado);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pais adicionar(@RequestBody Pais pais) {
		return service.salvar(pais);
	}
	
	@PutMapping(path = "/{paisId}")
	public ResponseEntity<Pais> atualizar(@PathVariable Long paisId, @RequestBody Pais pais){
		Pais paisEncontrado = service.buscar(paisId);
		
		if(paisEncontrado == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(pais, paisEncontrado, "id");
		return ResponseEntity.ok(service.salvar(paisEncontrado));
	}
	
	@DeleteMapping("/{paisId}")
	public void apagar(@PathVariable Long paisId) {
		service.excluir(paisId);
	}
}
