package com.pgrsoft.gestionparking.backend.ServicesDAOImpl;

import org.junit.Test;

import com.pgrsoft.gestionparking.backend.dao.PlazaDAO;
import com.pgrsoft.gestionparking.backend.dao.impl.PlazaDAOImpl;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;

/**
 * IMPORTANTE! Todos los métodos @Test deben ser INDEPENDIENTES unos de otros
 * 
 * Esto significa que se pueden ejecutar en cualquier order.
 * Esto significa que deben "dejar las cosas" en el mismo estado.
 * 
 * @author Training438admin
 *
 */
public class PlazaDAOImplTest {
	
	private PlazaDAO plazaDAO = new PlazaDAOImpl();

	@Test
	public void test() throws DAOException{
		
		plazaDAO.read(100);
	}
	

	
}
