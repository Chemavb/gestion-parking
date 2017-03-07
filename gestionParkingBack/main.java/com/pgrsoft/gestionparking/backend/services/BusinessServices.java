package com.pgrsoft.gestionparking.backend.services;

import java.util.Date;
import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.model.Propietario;

public interface BusinessServices {
	
	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return Devuelve una lista de las plazas disponibles entre fechas (no est�n bloqueadas y no est�n reservadas)
	 */
	public List<Plaza> plazasDisponiblesEntreFechas (Date fechaInicio, Date fechaFin) throws BusinessServiceException;
	
	/**
	 * Crea una reserva. En caso de que la reserva no sea viable (porque la plaza est� bloqueada o ya est� reservada) lanza una excepci�n.
	 * 
	 * @param user
	 * @param plaza
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public void reservar(Propietario user, Plaza plaza, Date fechaInicio, Date fechaFin) throws BusinessServiceException;

	public Plaza plazasDisponiblesPropietario(String dni, Date fechaInicio, Date fechaFin) throws BusinessServiceException;

}
