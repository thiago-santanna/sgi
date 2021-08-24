package com.tsswebapps.sgi.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public EstadoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public EstadoNaoEncontradoException(Long id) {
		this(String.format("Estado não encontrado, %d", id));
	}

	private static final long serialVersionUID = 1L;

}
