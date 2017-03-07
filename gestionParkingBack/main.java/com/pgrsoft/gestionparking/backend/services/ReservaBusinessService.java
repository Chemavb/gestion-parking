package com.pgrsoft.gestionparking.backend.services;

import java.util.List;

import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Reserva;

public interface ReservaBusinessService {
	public void 			create(Reserva reserva) throws BusinessServiceException;
	public Reserva 			read(int numero) 		throws BusinessServiceException;
	public void 			update(Reserva reserva) throws BusinessServiceException;
	public void 			delete(int numero) 		throws BusinessServiceException;
	public List<Reserva> 	getAll() 				throws BusinessServiceException;
}
