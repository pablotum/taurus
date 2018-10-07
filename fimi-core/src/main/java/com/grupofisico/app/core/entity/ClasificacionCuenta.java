package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClasificacionCuenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClasificacionCuenta;
	
	@Column(length = 100, nullable = false, unique = true)
	private String clasificacionCuenta;
	
	
	
	public Long getIdClasificacionCuenta() {
		return idClasificacionCuenta;
	}



	public void setIdClasificacionCuenta(Long idClasificacionCuenta) {
		this.idClasificacionCuenta = idClasificacionCuenta;
	}



	public String getClasificacionCuenta() {
		return clasificacionCuenta;
	}



	public void setClasificacionCuenta(String clasificacionCuenta) {
		this.clasificacionCuenta = clasificacionCuenta;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
