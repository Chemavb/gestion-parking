package com.pgrsoft.gestionparking.backend.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import com.pgrsoft.gestionparking.backend.dao.ReservaDAO;
import com.pgrsoft.gestionparking.backend.exceptions.DAOException;
import com.pgrsoft.gestionparking.backend.model.Reserva;

@Configuration
@Transactional
public class ReservaDAOImpl implements ReservaDAO {

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void create(Reserva reserva) throws DAOException {
		
		try{
			System.out.println("RESERVA EN DAO: "+reserva);
			
			/*em.persist(reserva);
			em.flush();*/
			em.merge(reserva);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("Error en integración en create(Reserva reserva)");
		}finally{
			em.close();
		}
	}

	@Override
	public Reserva read(int numero) throws DAOException {
		
		try{
			
			Reserva reserva = em.find(Reserva.class, numero);
			return reserva;

		}catch(Exception e){
			throw new DAOException("Error en integración");
		}finally{
		em.close();
		}
	}

	@Override
	public void update(Reserva reserva) throws DAOException {
		
		try{
			
			em.refresh(reserva);

		}catch(Exception e){
			throw new DAOException("Error en integración");
		}finally{
		em.close();
		}
	}

	@Override
	public void delete(int numero) throws DAOException {
		
		try{
			
			Reserva reserva = em.find(Reserva.class, numero);
			em.remove(reserva);
			
		}catch(Exception e){
			throw new DAOException("Error en integración"+e.getMessage());
		}finally{
		em.close();
		}
	}

	@Override
	public List<Reserva> getAll() throws DAOException {
		
		try{
			
			List<Reserva> reservas = em.createQuery("select r from Reserva as r", Reserva.class).getResultList();
			return reservas;

		}catch(Exception e){
			throw new DAOException("Error en integración");
		}finally{
		em.close();
		}
	}

}
