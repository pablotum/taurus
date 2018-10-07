package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Banco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanco;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 150)
	private String direccion;
	
	@Column(length = 100)
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais pais;
	
	@Column(length = 50)
	private String aba;
	
	@Column(length = 50)
	private String swift;
	
	
	
	public Long getIdBanco() {
		return idBanco;
	}




	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getCiudad() {
		return ciudad;
	}




	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}




	public Pais getPais() {
		return pais;
	}




	public void setPais(Pais pais) {
		this.pais = pais;
	}




	public String getAba() {
		return aba;
	}




	public void setAba(String aba) {
		this.aba = aba;
	}




	public String getSwift() {
		return swift;
	}




	public void setSwift(String swift) {
		this.swift = swift;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
