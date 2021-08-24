package com.tsswebapps.sgi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
//classe de exemplo para fins didáticos para mostrar que posso herdar o responseStatus e usar o erro com dois construtores
public class SemElementoException extends ResponseStatusException {
	private static final long serialVersionUID = 1L;

	public SemElementoException(HttpStatus status, String mensagem) {
		super(status, mensagem);
	}

	public SemElementoException(String mensagem) {
		this(HttpStatus.BAD_REQUEST ,mensagem);
	}
}
