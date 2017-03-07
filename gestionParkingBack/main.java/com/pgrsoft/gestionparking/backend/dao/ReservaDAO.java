package com.pgrsoft.gestionparking.backend.dao;

import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Reserva;

public interface ReservaDAO {
	
	public void create(Reserva reserva) throws DAOException;
	
	public Reserva read(int numero) throws DAOException;
	
	public void update(Reserva reserva) throws DAOException;
	
	public void delete(int numero) throws DAOException;
	
	// Obtención de listas
	
	public List<Reserva> getAll() throws DAOException;

}
