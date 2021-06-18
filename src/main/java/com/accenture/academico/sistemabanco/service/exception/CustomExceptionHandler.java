package com.accenture.academico.sistemabanco.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(NegocioException.class)
	public ResponseStatusException negocio(NegocioException e) {
		return new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseStatusException notFound(EntityNotFoundException e) {
		return new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
	}
	

}
