package com.pgrsoft.gestionparking.backend.services;

import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Plaza;


public interface PlazaBusinessService {
	public Plaza 		read(int numero) 	throws BusinessServiceException;
	public List<Plaza> 	getAll() 			throws BusinessServiceException;
}
