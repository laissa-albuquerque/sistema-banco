package com.accenture.academico.sistemabanco.service.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 4422280992344086464L;
	
	@Override
    public synchronized Throwable fillInStackTrace(){
		return this;		
	}

	public EntityNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
