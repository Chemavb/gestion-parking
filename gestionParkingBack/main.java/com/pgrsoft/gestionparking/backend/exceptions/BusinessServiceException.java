package com.pgrsoft.gestionparking.backend.exceptions;

public class BusinessServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;
		
	public BusinessServiceException(){
		
	}

	public BusinessServiceException(String mensaje) {
		
		super(mensaje);
	}

}
