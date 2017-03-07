package com.pgrsoft.gestionparking.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionparking.backend.dao.ReservaDAO;
import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Reserva;
import com.pgrsoft.gestionparking.backend.services.ReservaBusinessService;

@Configuration
public class ReservaBusinessServicesImpl implements ReservaBusinessService {
	
	@Autowired
	ReservaDAO reservaDAO;

	@Override
	public void create(Reserva reserva) throws BusinessServiceException {

		try{
			
			reservaDAO.create(reserva);
			
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}
		
	}

	@Override
	public Reserva read(int numero) throws BusinessServiceException {
		
		try{
			
			Reserva reserva = reservaDAO.read(numero);
			return reserva;
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}	
	}

	@Override
	public void update(Reserva reserva) throws BusinessServiceException {

		try{
			
			reservaDAO.update(reserva);
			
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}
	}

	@Override
	public void delete(int numero) throws BusinessServiceException {

		try{
			
			reservaDAO.delete(numero);
			
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business"+e.getMessage());
		}
	}

	@Override
	public List<Reserva> getAll() throws BusinessServiceException {

		try{
			
			List<Reserva> reservas = reservaDAO.getAll();
			return reservas;
			
		}catch(Exception e){
			throw new BusinessServiceException("Error en business");
		}
	}

}
