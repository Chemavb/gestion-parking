package com.pgrsoft.gestionparking.backend.services;

import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Propietario;

public interface PropietarioBusinessService {
	public void 				create(Propietario propietario) 	throws BusinessServiceException;
	public Propietario 			read(String DNI) 					throws BusinessServiceException;
	public void 				update(Propietario propietario) 	throws BusinessServiceException;
	public void 				delete(String DNI) 					throws BusinessServiceException;
	public List<Propietario> 	getAll() 							throws BusinessServiceException;
}


