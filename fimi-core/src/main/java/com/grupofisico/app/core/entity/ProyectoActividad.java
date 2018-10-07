package com.grupofisico.app.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProyectoActividad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyectoActividad;
	
	
	@Column(length = 100)
	private String actividad;
	
	@Column(length = 200)
	private String descripcion;
	
	@Column
	private Date inicio;
	
	@Column
	private Date fin;
	
	@Column
	private Date fecha;
	
	@Column
	private Boolean estado;
	
	
	
	public Long getIdProyectoActividad() {
		return idProyectoActividad;
	}



	public void setIdProyectoActividad(Long idProyectoActividad) {
		this.idProyectoActividad = idProyectoActividad;
	}



	public String getActividad() {
		return actividad;
	}



	public void setActividad(String actividad) {
		this.actividad = actividad;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
