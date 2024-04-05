package com.farsousa.arquiteturahexagonal.infra.exceptions;

public class NaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
