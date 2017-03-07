package com.pgrsoft.gestionparking.backend.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionparking.backend.dao.PropietarioDAO;
import com.pgrsoft.gestionparking.backend.dao.ReservaDAO;
import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.model.Propietario;
import com.pgrsoft.gestionparking.backend.model.Reserva;
import com.pgrsoft.gestionparking.backend.services.BusinessServices;

@Configuration
public class BusinessServicesImpl implements BusinessServices{
	
	@Autowired
	ReservaDAO reservaDAO;
	
	@Autowired
	PropietarioDAO propietarioDAO;

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Plaza> plazasDisponiblesEntreFechas(Date fechaInicio, Date fechaFin) throws BusinessServiceException {

		List<Plaza> plazas = new ArrayList<Plaza>();
		try {
			List<Reserva> reservas = reservaDAO.getAll(); //Lista de todas las plazas
			
			for(Reserva reserva: reservas) {
				Date fechaInicioReserva = reserva.getInicio();
				Date fechaFinReserva = reserva.getFin();
				boolean disponibleAntes = fechaInicio.before(fechaInicioReserva) && fechaFin.before(fechaFinReserva);
				boolean disponibleDespues = fechaInicio.after(fechaFinReserva) && fechaFin.after(fechaFinReserva);
				
				if(!reserva.getPlaza().isBloqueada() && (disponibleAntes || disponibleDespues) ) {
					plazas.add(reserva.getPlaza());
				}
			}
		} catch (DAOException e) {
			// Algo ha ido mal en la capa de los DAOs. Podemos mirar que es...
			// Pero la excepcion tiene que aflorar en la siguiente capa en forma de BusinessServiceException...

			throw new BusinessServiceException();
		}
		
		return plazas;
		
	}
	
	@Override
	public Plaza plazasDisponiblesPropietario(String DNI, Date fechaInicio, Date fechaFin) throws BusinessServiceException{
		
		Plaza plazaPropietario = null;
		
		try {
			List<Plaza> plazas = plazasDisponiblesEntreFechas(fechaInicio,fechaFin);
			Propietario propietario = propietarioDAO.read(DNI);
			
			for(Plaza plaza:plazas){
				if(plaza.getNumero() == propietario.getPlaza().getNumero()){
					plazaPropietario = plaza;
				}
			}
			
			
		} catch (BusinessServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plazaPropietario;
	}

	@Override
	public void reservar(Propietario user, Plaza plaza, Date fechaInicio, Date fechaFin) throws BusinessServiceException {

		try{
			Date fechaReserva = new Date();
			System.out.println("fechaReserva: "+fechaReserva+"fechaInicio: "+fechaInicio+"fechaFin: "+fechaFin);
			Reserva reserva = new Reserva(user,plaza,fechaReserva,fechaInicio,fechaFin);
			reservaDAO.create(reserva);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new BusinessServiceException("Error en business en reservar(...)");
			
		}
		
	}

}
