package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlujoCuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFlujoCuenta;
	
	@Column(length = 100, nullable = false, unique = true)
	private String flujoCuenta;

	public Long getIdFlujoCuenta() {
		return idFlujoCuenta;
	}

	public void setIdFlujoCuenta(Long idFlujoCuenta) {
		this.idFlujoCuenta = idFlujoCuenta;
	}

	public String getFlujoCuenta() {
		return flujoCuenta;
	}

	public void setFlujoCuenta(String flujoCuenta) {
		this.flujoCuenta = flujoCuenta;
	}
	
	
}
