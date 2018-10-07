package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moneda implements Serializable  {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMoneda;
	
	@Column(length = 100, nullable = false)
	private String moneda;
	
	@Column(length = 5)
	private String simbolo;
	
	@Column
	private Boolean principal;
	
	
	
	public String getSimbolo() {
		return simbolo;
	}



	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}



	public Long getIdMoneda() {
		return idMoneda;
	}



	public void setIdMoneda(Long idMoneda) {
		this.idMoneda = idMoneda;
	}



	public String getMoneda() {
		return moneda;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public Boolean getPrincipal() {
		return principal;
	}



	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
