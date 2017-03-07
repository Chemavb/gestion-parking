package com.pgrsoft.gestionparking.backend.ServicesDAOImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.pgrsoft.gestionparking.backend.dao.PropietarioDAO;
import com.pgrsoft.gestionparking.backend.dao.impl.PropietarioDAOImpl;
import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Propietario;
import com.pgrsoft.gestionparking.backend.services.PropietarioBusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropietarioDAOImpl.class, loader = AnnotationConfigContextLoader.class)
public class JUnitSpringExample {
	
	@Autowired
	private PropietarioBusinessService propietarioBusinessService;
	
	@Test
	public void test1(){
		System.out.println("ANTES!");
		try{
			Propietario propietario = null;
			propietario = this.propietarioBusinessService.read("46334783K");
			assertNotNull(propietario);
			assertEquals(propietario.getDNI(), "46334783K");
			assertEquals(propietario.getTelefonoMovil(), "608786522");
			System.out.println("PROPIETARIO: " + propietario);
		}catch(BusinessServiceException e){
			e.printStackTrace();
		}
		
		System.out.println("DESPUES!");
	}
	
}
