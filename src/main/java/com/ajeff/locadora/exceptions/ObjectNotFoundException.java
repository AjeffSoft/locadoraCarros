package com.ajeff.locadora.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(Object id) {
		super("Registro não encontrado: ID " + id);
	}

}
