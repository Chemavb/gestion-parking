package com.pgrsoft.gestionparking.backend.dao;

import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Propietario;

public interface PropietarioDAO {
	
	// Operaciones CRUD
	
	public void create(Propietario propietario) throws DAOException;
	
	public Propietario read(String DNI) throws DAOException;
	
	public void update(Propietario propietario) throws DAOException;
	
	public void delete(String DNI) throws DAOException;
	
	// Obtención de listas
	
	public List<Propietario> getAll() throws DAOException;
}
