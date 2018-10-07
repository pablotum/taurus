package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsoCuenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsoCuenta;
	
	@Column(length = 100, nullable = false, unique = true)
	private String usoCuenta;
	
	
	
	public Long getIdUsoCuenta() {
		return idUsoCuenta;
	}



	public void setIdUsoCuenta(Long idUsoCuenta) {
		this.idUsoCuenta = idUsoCuenta;
	}



	public String getUsoCuenta() {
		return usoCuenta;
	}



	public void setUsoCuenta(String usoCuenta) {
		this.usoCuenta = usoCuenta;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
