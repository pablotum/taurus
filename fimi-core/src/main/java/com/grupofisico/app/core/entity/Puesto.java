package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puesto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuesto;
	
	@Column(length = 20)
	private String codigo;
	
	@Column(length = 100)
	private String puesto;
	
	@Column(length = 150)
	private String descripcion;
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Long getIdPuesto() {
		return idPuesto;
	}



	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}



	public String getPuesto() {
		return puesto;
	}



	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
