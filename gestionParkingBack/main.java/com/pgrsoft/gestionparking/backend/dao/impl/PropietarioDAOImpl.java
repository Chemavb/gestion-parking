package com.pgrsoft.gestionparking.backend.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import com.pgrsoft.gestionparking.backend.dao.PropietarioDAO;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.model.Propietario;
import com.pgrsoft.gestionparking.backend.model.Reserva;

@Configuration
@Transactional
public class PropietarioDAOImpl implements PropietarioDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void create(Propietario propietario)throws DAOException {
		
		try{
			em.persist(propietario.getPlaza());
			em.flush();
			em.persist(propietario);
		}catch(Exception e){
			throw new DAOException("Error en integración"+e.getMessage());
		}finally{
			em.close();
	
		}
	}

	@Override
	public Propietario read(String DNI) throws DAOException {
		
		try{
			
			Propietario propietario = em.find(Propietario.class, DNI);
			return propietario;

		}catch(Exception e){
			throw new DAOException("Error en integración");
		}finally{
			em.close();
		}
	}

	@Override
	public void update(Propietario propietario) throws DAOException {
		
		try{
			
		em.merge(propietario);
		
		}catch(Exception e){
		}finally{
		em.close();
		}
	}

	@Override
	public void delete(String DNI) {
		
		try{
			System.out.println("LLEGA DELETE");
			Propietario propietario = read(DNI);
			em.remove(propietario);
			em.remove(propietario.getPlaza());
			System.out.println("SALE DELETE");
			}catch(Exception e){
			}finally{
			em.close();
			}
	}

	@Override
	public List<Propietario> getAll() throws DAOException {
		
		try{
			
		System.out.println("em: " + em);	
			
		List<Propietario> propietarios = em.createQuery("select p from Propietario as p", Propietario.class).getResultList();
		return propietarios;

		}catch(Exception e){
			throw new DAOException("Error en integración");
		}finally{
			em.close();

		}
	}

}
