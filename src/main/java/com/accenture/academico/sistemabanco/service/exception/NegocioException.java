package com.accenture.academico.sistemabanco.service.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = -8093589601674204748L;

	@Override
	public synchronized Throwable fillInStackTrace(){
		return this;
	}

	public NegocioException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NegocioException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
