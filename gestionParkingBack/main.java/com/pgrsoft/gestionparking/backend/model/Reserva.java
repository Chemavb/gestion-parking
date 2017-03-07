package com.pgrsoft.gestionparking.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="reservas")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GENERADOR_NUMERO_RESERVA")
	@TableGenerator(name="GENERADOR_NUMERO_RESERVA", table= "ID_GEN", pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE")
	@Id
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="IDPROPIETARIO")
	private Propietario propietario;
	
	@OneToOne
	@JoinColumn(name="IDPLAZA")
	private Plaza plaza;
	
	private Date fecha;
	private Date inicio;
	private Date fin;
	private String observaciones;
	
	public Reserva(){
		
	}
	
	public Reserva(Propietario propietario, Plaza plaza, Date fecha, Date inicio, Date fin) {
		this.propietario = propietario;
		this.plaza = plaza;
		this.fecha = fecha;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public Reserva(int codigo, Propietario propietario, Plaza plaza, Date fecha, Date inicio, Date fin) {
		this.codigo = codigo;
		this.propietario = propietario;
		this.plaza = plaza;
		this.fecha = fecha;
		this.inicio = inicio;
		this.fin = fin;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Plaza getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
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
		result = prime * result + codigo;
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
		Reserva other = (Reserva) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", propietario=" + propietario + ", plaza=" + plaza + ", fecha=" + fecha
				+ ", inicio=" + inicio + ", fin=" + fin + ", observaciones=" + observaciones + "]";
	}
}
