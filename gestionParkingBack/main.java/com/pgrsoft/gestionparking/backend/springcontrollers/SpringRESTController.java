package com.pgrsoft.gestionparking.backend.springcontrollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.model.Propietario;
import com.pgrsoft.gestionparking.backend.model.Reserva;
import com.pgrsoft.gestionparking.backend.services.BusinessServices;
import com.pgrsoft.gestionparking.backend.services.PropietarioBusinessService;
import com.pgrsoft.gestionparking.backend.services.ReservaBusinessService;

@RestController
@RequestMapping("/rest")
public class SpringRESTController {
	
	@Autowired
	private PropietarioBusinessService propietarioBusinessService;
	
	@Autowired
	private ReservaBusinessService reservaBusinessService;
	
	@Autowired
	private BusinessServices businessServices;
	
	@RequestMapping(value="/propietario/{dni}", method = RequestMethod.GET)
	public ResponseEntity<Propietario> getPropietarioByDNI(@PathVariable(value="dni") String dni){
		
		Propietario propietario = null;
		
		try {
			propietario = this.propietarioBusinessService.read(dni);
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Propietario>(propietario, HttpStatus.OK);
	}
	
	//**************************LIST******************************************************************

	
	@RequestMapping("/propietarios")
	public List<Propietario> getPropietarios(){
		
		List<Propietario> propietarios = null;
		
		try{
			propietarios = this.propietarioBusinessService.getAll();
		}catch (BusinessServiceException e) {			
			e.printStackTrace();
		}
		return propietarios;
	}
	
	
	@RequestMapping("/prueba")
	public Propietario damePropietario(){
		
		Propietario propietario = new Propietario("666", "Damian", "Lopez","Inferno");
		
		return propietario;
	}
	
	//**************************CREATE******************************************************************

	
	@RequestMapping(value="/propietario/", method=RequestMethod.POST)
	public ResponseEntity<Void> createPropietario(@RequestBody Propietario propietario, UriComponentsBuilder ucBuilder){
		
		System.out.println("Vamos a dar de alta: " + propietario);
		
		try {
			this.propietarioBusinessService.create(propietario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/propietario/{dni}").buildAndExpand(propietario.getDNI()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//**************************DELETE******************************************************************
	
	@RequestMapping(value="/propietario/{dni}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePropietario(@PathVariable("dni") String dni){
		
		try {
			this.propietarioBusinessService.delete(dni);
		} catch (BusinessServiceException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//*************************UPDATE**********************************************************************
	
	@RequestMapping(value="/propietario/",method=RequestMethod.PUT)
	public ResponseEntity<Propietario> updatePropietario(@RequestBody Propietario propietario){
		
		try {
			this.propietarioBusinessService.update(propietario);
		} catch (BusinessServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Propietario>(propietario, HttpStatus.OK);
	}
	
	@RequestMapping(value="/reserva/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Reserva> getReservaByCodigo(@PathVariable(value="codigo") int codigo){
		
		Reserva reserva= null;
		
		try {
			reserva = this.reservaBusinessService.read(codigo);
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
	}
	
	@RequestMapping("/reservas")
	public List<Reserva> getReservas(){
		
		List<Reserva> reservas = null;
		
		try{
			reservas = this.reservaBusinessService.getAll();
		}catch (BusinessServiceException e) {			
			e.printStackTrace();
		}
		return reservas;
	}
	
	@RequestMapping(value="/reserva/", method=RequestMethod.POST)
	public ResponseEntity<Void> createReserva(@RequestBody Reserva reserva, UriComponentsBuilder ucBuilder){
		
		System.out.println("Vamos a dar de alta: " + reserva);
		
		try {
			this.reservaBusinessService.create(reserva);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/propietario/{dni}").buildAndExpand(reserva.getCodigo()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/reserva/{codigo}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReserva(@PathVariable("codigo") int codigo){
		
		try {
			this.reservaBusinessService.delete(codigo);
		} catch (BusinessServiceException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/plazasdisponibles/{inicio}&{fin}",method=RequestMethod.GET)
	public List<Plaza> getPlazasDisponibles(@PathVariable("inicio") @DateTimeFormat(pattern="yyyy-MM-dd") Date inicio, @PathVariable("fin") @DateTimeFormat(pattern="yyyy-MM-dd") Date fin){
	
		List<Plaza> plazas = null;
		
		try{
			plazas = this.businessServices.plazasDisponiblesEntreFechas(inicio, fin);
			System.out.println(plazas);
		}catch (BusinessServiceException e) {			
			e.printStackTrace();
		}
		return plazas;
	}
	
	@RequestMapping(value="/plazasdisponiblespropietario/{dni}&{inicio}&{fin}",method=RequestMethod.GET)
	public Plaza getPlazasDisponiblesPropietario(@PathVariable("dni") String dni, @PathVariable("inicio") @DateTimeFormat(pattern="yyyy-MM-dd") Date inicio, @PathVariable("fin") @DateTimeFormat(pattern="yyyy-MM-dd") Date fin){
	
		Plaza plaza = null;
		
		try{
			plaza = this.businessServices.plazasDisponiblesPropietario(dni, inicio, fin);
			System.out.println(plaza);
		}catch (BusinessServiceException e) {			
			e.printStackTrace();
		}
		return plaza;
	}
	
}
