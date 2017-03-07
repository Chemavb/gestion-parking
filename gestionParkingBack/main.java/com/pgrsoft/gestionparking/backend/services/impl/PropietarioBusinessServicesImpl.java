package com.pgrsoft.gestionparking.backend.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionparking.backend.dao.PropietarioDAO;
import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Propietario;
import com.pgrsoft.gestionparking.backend.services.PropietarioBusinessService;

@Configuration
public class PropietarioBusinessServicesImpl implements PropietarioBusinessService {
	
	@Autowired
	PropietarioDAO propietarioDAO;

	@Override
	public void create(Propietario propietario) throws BusinessServiceException {
		
		try{
			
			propietarioDAO.create(propietario);
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business" + e.getMessage());
		}
	}

	@Override
	public Propietario read(String DNI) throws BusinessServiceException {
		
		try{
			
			Propietario propietario = propietarioDAO.read(DNI);
			return propietario;
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}		
	}

	@Override
	public void update(Propietario propietario) throws BusinessServiceException {
		
		try{
			System.out.println("ANTES DE UPDATE");
			propietarioDAO.update(propietario);
			System.out.println("DESPUES DE UPDATE");
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}			
	}

	@Override
	public void delete(String DNI) throws BusinessServiceException {
		
		try{
			
			propietarioDAO.delete(DNI);
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}		
	}

	@Override
	public List<Propietario> getAll() throws BusinessServiceException {
		
		try{

			List<Propietario> propietarios = propietarioDAO.getAll();
			return propietarios;
			
		}catch(Exception e){
			throw new BusinessServiceException(e.getStackTrace().toString());
		}
	}

}
