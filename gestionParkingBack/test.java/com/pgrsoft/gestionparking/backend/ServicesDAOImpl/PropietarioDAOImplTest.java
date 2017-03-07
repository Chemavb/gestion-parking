package com.pgrsoft.gestionparking.backend.ServicesDAOImpl;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import com.pgrsoft.gestionparking.backend.dao.PropietarioDAO;
import com.pgrsoft.gestionparking.backend.dao.impl.PropietarioDAOImpl;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Planta;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.model.Propietario;

public class PropietarioDAOImplTest {

	private PropietarioDAO propietarioDAO = new PropietarioDAOImpl();

	private String DNI = "45444837K";
	private Propietario propietario1 = new Propietario(DNI,"Carlos","Lopez","Peralta");
	
	@Test
	public void create() throws DAOException{
		propietarioDAO.create(propietario1);
		Propietario propietario2 = propietarioDAO.read(DNI);
		assertEquals(propietario1, propietario2);
		
		// Dejamos las cosas como estaban
		propietarioDAO.delete(DNI);
	}

	@Test
	public void read() throws DAOException{
		propietarioDAO.create(propietario1);
		Propietario propietario2 = propietarioDAO.read(DNI);
		assertEquals(propietario1, propietario2);
		
		// Dejamos las cosas como estaban...
		propietarioDAO.delete(propietario1.getDNI());
	}
	
	@Test
	public void update() throws DAOException{
		
		// Esto hay que mejorarlo....
		
		String strBefore = "BU";
		String strAfter = "AU";
		
		Propietario propietario = new Propietario ();
		Plaza plaza = new Plaza(100,Planta.SOTANO_1);
		
		propietario.setDNI(DNI);
		propietario.setPlaza(plaza);
		propietario.setNombre(strBefore);
		propietario.setApellido1(strBefore);
		propietario.setApellido2(strBefore);
		propietario.setDireccion(strBefore);
		propietario.setEmail(strBefore);
		propietario.setNumero(strBefore);
		propietario.setPlanta(strBefore);
		propietario.setPuerta(strBefore);
		propietario.setTelefonoFijo(strBefore);
		propietario.setTelefonoMovil(strBefore);
		
		System.out.println("propietario antes actualizar: " + propietario);
		propietarioDAO.create(propietario);	//
		
		Propietario propietario2 = new Propietario();
		Plaza plaza2 = new Plaza(200,Planta.SOTANO_1);
		propietario2.setDNI(DNI);
		propietario2.setPlaza(plaza2);
		propietario2.setNombre(strAfter);
		propietario2.setApellido1(strAfter);
		propietario2.setApellido2(strAfter);
		propietario2.setDireccion(strAfter);
		propietario2.setEmail(strAfter);
		propietario2.setNumero(strAfter);
		propietario2.setPlanta(strAfter);
		propietario2.setPuerta(strAfter);
		propietario2.setTelefonoFijo(strAfter);
		propietario2.setTelefonoMovil(strAfter);
		
		propietarioDAO.update(propietario2);
		
		propietario = propietarioDAO.read(DNI);
		
		assertEquals(strAfter, propietario.getNombre());
		assertEquals(strAfter, propietario.getApellido1());
		assertEquals(strAfter, propietario.getApellido1());
		assertEquals(strAfter, propietario.getDireccion());
		assertEquals(strAfter, propietario.getEmail());
		assertEquals(strAfter, propietario.getDireccion());
		assertEquals(strAfter, propietario.getEmail());
		assertEquals(strAfter, propietario.getNumero());
		assertEquals(strAfter, propietario.getPlanta());
		assertEquals(strAfter, propietario.getPuerta());
		assertEquals(strAfter, propietario.getTelefonoFijo());
		assertEquals(strAfter, propietario.getTelefonoMovil());
		assertEquals(200, propietario.getPlaza().getNumero());
		
		System.out.println("propietario actualizado: " + propietario);
		
		// Dejamos las cosas como estaban
		propietarioDAO.delete(DNI);
	}
	
	@Test
	public void delete() throws DAOException{
		int nPropietarios = 0;
		int nPropietariosDespuesEliminar = 0;
	
		propietarioDAO.create(propietario1);
		nPropietarios = propietarioDAO.getAll().size();
		
		// Dejamos las cosas como estaban
		propietarioDAO.delete(propietario1.getDNI());
		nPropietariosDespuesEliminar = propietarioDAO.getAll().size();
		
		assertTrue(nPropietariosDespuesEliminar == nPropietarios - 1);
	}
	
	@Test
	public void getAll() throws DAOException{
		List<Propietario> propietarios = propietarioDAO.getAll();
		assertEquals(3, propietarios.size());
		propietarioDAO.create(new Propietario(DNI,"A","B","C"));
		propietarios = propietarioDAO.getAll();
		assertEquals(4, propietarios.size());
		
		// Dejamos las cosas como estaban
		propietarioDAO.delete(DNI);
	}	
}
