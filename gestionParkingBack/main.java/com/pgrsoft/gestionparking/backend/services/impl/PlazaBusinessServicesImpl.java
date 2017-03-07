package com.pgrsoft.gestionparking.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionparking.backend.dao.PlazaDAO;
import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.services.PlazaBusinessService;

@Configuration
public class PlazaBusinessServicesImpl implements PlazaBusinessService {
	
	@Autowired
	PlazaDAO plazaDAO;

	@Override
	public Plaza read(int numero) throws BusinessServiceException {

		try{
			
			Plaza plaza = plazaDAO.read(numero);
			return plaza;
			
		}catch(Exception e){
			
			throw new BusinessServiceException("Error en business");

		}
		
	}

	@Override
	public List<Plaza> getAll() throws BusinessServiceException {

		try{
			
			List<Plaza> lista = plazaDAO.getAll();
			return lista;

		}catch(Exception e){
			
			throw new BusinessServiceException("Error en business");
			
		}

	}

}
