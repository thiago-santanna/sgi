package com.tsswebapps.sgi.domain.exception;

public class PaisNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PaisNaoEncontradoException(String mensagem) {
		super(mensagem);
		
	}
	
	public PaisNaoEncontradoException(Long paisId) {
		this(String.format("País não encontrado", paisId));
	}

}
