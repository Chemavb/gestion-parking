package com.pgrsoft.gestionparking.backend.springcontrollers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.pgrsoft.gestionparking.backend.exceptions.BusinessServiceException;
import com.pgrsoft.gestionparking.backend.model.Planta;
import com.pgrsoft.gestionparking.backend.model.Plaza;
import com.pgrsoft.gestionparking.backend.model.Propietario;
import com.pgrsoft.gestionparking.backend.model.Reserva;
import com.pgrsoft.gestionparking.backend.services.BusinessServices;
import com.pgrsoft.gestionparking.backend.services.PlazaBusinessService;
import com.pgrsoft.gestionparking.backend.services.PropietarioBusinessService;
import com.pgrsoft.gestionparking.backend.services.ReservaBusinessService;

@Controller
@RequestMapping("/pruebas")
public class ControladorSpring {
	
	/* *********************************************************************
	 * 
	 * Declaramos todos los servicios que va a necesitar nuestro controlador
	 * 
	 * **********************************************************************/
	
	@Autowired
	private BusinessServices businessServices;
	
	@Autowired 
	private PlazaBusinessService plazaBusinessService;
	
	@Autowired
	private ReservaBusinessService reservaBusinessService;
	
	@Autowired
	private PropietarioBusinessService propietarioBusinessService;
	
	/* *********************************************************************
	 * 
	 * Implementamos todos los métodos de nuestro controlador
	 * 
	 * **********************************************************************/
	
	@RequestMapping("/realizar_reserva")
	public ModelAndView realizarReserva(@RequestParam("plaza") int numero,
			                            @RequestParam("DNI") String DNI,
			                            @RequestParam("inicio") String inicio,
			                            @RequestParam("fin") String fin) throws BusinessServiceException, ParseException{
									    
		
		try{
			Plaza plaza = plazaBusinessService.read(numero);
			Propietario propietario = propietarioBusinessService.read(DNI);
			businessServices.reservar(propietario, plaza, new SimpleDateFormat("yyyy-MM-dd").parse(inicio), new SimpleDateFormat("yyyy-MM-dd").parse(fin));
			return reservas();
			
		}catch(BusinessServiceException e){
			
			System.out.println(e.getMessage());
			throw new BusinessServiceException("Error en BUSINESS");
		}
	}
	
	@RequestMapping("/reserva_alta")
	public ModelAndView altaReserva() throws BusinessServiceException{
		
		try{
		List<Propietario> propietarios = propietarioBusinessService.getAll();
		
		return new ModelAndView("altareserva", "propietarios", propietarios);
		
		}catch(BusinessServiceException e){
			throw new BusinessServiceException("Error en BUSINESS");
		}
	}
	
	@RequestMapping("/listaplazasreserva")
	public ModelAndView crearPlazaReservaList(@RequestParam("DNI") String DNI
											 ,@RequestParam("inicio") @DateTimeFormat(pattern="yyyy-MM-dd") Date inicio
											 ,@RequestParam("fin") @DateTimeFormat(pattern="yyyy-MM-dd") Date fin) throws BusinessServiceException, ParseException{
		try{
			
			List<Plaza> plazas = businessServices.plazasDisponiblesEntreFechas(inicio, fin);
			List<Plaza> plazas2 = new ArrayList<Plaza>();
			Propietario propietario = propietarioBusinessService.read(DNI);
			
			for(Plaza plaza: plazas){
				System.out.println("PLAZAS:"+plazas);
				if(propietario.getPlaza().getNumero() == plaza.getNumero()){
					plazas2.add(plaza);
				}
				
			}
			
			ModelAndView mav = new ModelAndView("listaplazareserva", "plazas", plazas2);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			mav.addObject("DNI",DNI);
			mav.addObject("inicio",df.format(inicio));
			mav.addObject("fin",df.format(fin));
			return mav;
		}catch(BusinessServiceException e){
			throw new BusinessServiceException("Error en BUSINESS");
		}
	}
	
	@RequestMapping("/propietarios")
	public ModelAndView propietarios() throws BusinessServiceException{
		
		List<Propietario> propietarios = null;
		try {
			propietarios = this.propietarioBusinessService.getAll();
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		}
		return new ModelAndView("listapropietarios", "propietarios", propietarios);
		
	}
	
	@RequestMapping("/borrarpropietario")
	public ModelAndView borrarPropietario(@RequestParam("prop") String DNI) throws BusinessServiceException{
		
		propietarioBusinessService.delete(DNI);
		
		return propietarios();

	}
	
	@RequestMapping("/reservas")
	public ModelAndView reservas() throws BusinessServiceException{
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			reservas = this.reservaBusinessService.getAll();
		} catch (BusinessServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("listareservas","reservas", reservas);
		
	}
	
	@RequestMapping("/plazas")
	public ModelAndView plazas() throws BusinessServiceException{
		
		List<Plaza> plazas = null;
		try {
			plazas = this.plazaBusinessService.getAll();
		} catch (BusinessServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("listaplazas", "plazas", plazas);
		
	}
	
	@RequestMapping("/altapropietario")
	public ModelAndView altaPropietario(
			@RequestParam("p1") String DNI,
			@RequestParam("p2") String nombre,
			@RequestParam("p3") String apellido1,
			@RequestParam("p4") String apellido2,
			@RequestParam("p5") String direccion,
			@RequestParam("p6") String numero,
			@RequestParam("p7") String planta,
			@RequestParam("p8") String puerta,
			@RequestParam("p9") String email,
			@RequestParam("p10") String telefonoFijo,
			@RequestParam("p11") String telefonoMovil,
			@RequestParam("p12") Integer numeroPlaza,
			@RequestParam("p13") String plantaPlaza,
			@RequestParam("p14") Double largo,
			@RequestParam("p15") Double ancho,
			@RequestParam(value="p16", required=false, defaultValue="0") Boolean bloqueada,
			@RequestParam("p17") String observaciones) throws BusinessServiceException{
		
		Propietario propietario = new Propietario(DNI,nombre,apellido1,apellido2);
		propietario.setDireccion(direccion);
		propietario.setNumero(numero);
		propietario.setPlanta(planta);
		propietario.setPuerta(puerta);
		propietario.setEmail(email);
		propietario.setTelefonoFijo(telefonoFijo);
		propietario.setTelefonoMovil(telefonoMovil);
		
		Plaza plaza = new Plaza();
		plaza.setNumero(numeroPlaza);
		plaza.setPlanta(Planta.valueOf(plantaPlaza));
		plaza.setLargo(largo);
		plaza.setAncho(ancho);
		plaza.setBloqueada(bloqueada);
		plaza.setObservaciones(observaciones);
		
		propietario.setPlaza(plaza);
		
		try {
			this.propietarioBusinessService.create(propietario);
		} catch (BusinessServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propietarios();
	}
}
