package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoCuenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoCuenta;
	
	@Column(length = 100)
	private String tipoCuenta;
	
	
	
	public Long getIdTipoCuenta() {
		return idTipoCuenta;
	}



	public void setIdTipoCuenta(Long idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}



	public String getTipoCuenta() {
		return tipoCuenta;
	}



	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
