package com.pgrsoft.gestionparking.backend.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionparking.backend.dao.PlazaDAO;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Plaza;

@Configuration
public class PlazaDAOImpl implements PlazaDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public Plaza read(int numero) {
		Plaza plaza = em.find(Plaza.class, numero);
		em.close();
		return plaza;
	}

	@Override
	public List<Plaza> getAll() throws DAOException{
		try{
		List<Plaza> plazas = em.createQuery("select plaza from Plaza plaza", Plaza.class).getResultList();
		return plazas;
		}catch(Exception e){
			throw new DAOException("Error en capa de integración");
		}finally{
			em.close();
		}
	}

	
}
