package com.tsswebapps.sgi.api.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String Hello() {
		return "Olá Sou o recurso de teste do SGI.";
	}
}
