package com.pgrsoft.gestionparking.backend.exceptions;

public class DAOException extends Exception{
	private static final long serialVersionUID = 1L;

	public DAOException(){
		
	}

	public DAOException(String mensaje) {
		
		super(mensaje);
	}

}
