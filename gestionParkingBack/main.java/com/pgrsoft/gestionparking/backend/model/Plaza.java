package com.pgrsoft.gestionparking.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAZAS")
public class Plaza implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int numero;
	
	@Enumerated(EnumType.STRING)
	private Planta planta;
	
	private double ancho;
	private double largo;
	private boolean bloqueada = true;
	private String observaciones;
	
	public Plaza(){
		
	}
	
	public Plaza(int numero, Planta planta){
		this.numero = numero;
		this.planta = planta;
	}

	public Plaza(int numero, Planta planta, double ancho, double largo, boolean bloqueada) {
		super();
		this.numero = numero;
		this.planta = planta;
		this.ancho = ancho;
		this.largo = largo;
		this.bloqueada = bloqueada;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plaza other = (Plaza) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plaza [numero=" + numero + ", planta=" + planta + ", ancho=" + ancho + ", largo=" + largo
				+ ", bloqueada=" + bloqueada + ", observaciones=" + observaciones + "]";
	}
}
