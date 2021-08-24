package com.tsswebapps.sgi.domain.exception;

public class CidadeNaoEncontradoException extends EntidadeNaoEncontradaException {

	public CidadeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CidadeNaoEncontradoException(Long id) {
		this(String.format("Cidade não encontrada, %d", id));
	}

	private static final long serialVersionUID = 1L;

}
