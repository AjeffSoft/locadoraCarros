package com.ajeff.locadora.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ajeff.locadora.exceptions.DatabaseIntegrityException;
import com.ajeff.locadora.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String error = "Object not found";
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error, e.getMessage(), request.getRequestURI(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DatabaseIntegrityException.class)
	public ResponseEntity<StandardError> databaseIntegrity(DatabaseIntegrityException e, HttpServletRequest request){
		String error = "Erro de chave estrangeira";
		Integer status = HttpStatus.BAD_REQUEST.value();
		StandardError err = new StandardError(status, error, e.getMessage(), request.getRequestURI(), System.currentTimeMillis());
		return ResponseEntity.status(status).body(err);
	}

}
