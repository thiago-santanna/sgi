package com.tsswebapps.sgi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EntidadeEmUsoException extends RuntimeException {

	public EntidadeEmUsoException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
