package com.pgrsoft.gestionparking.backend.dao;

import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Plaza;

public interface PlazaDAO {

	public Plaza read(int numero) throws DAOException;
	
	public List<Plaza> getAll() throws DAOException;
	
}
