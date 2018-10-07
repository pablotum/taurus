package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConvenioArchivo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvenioArchivo;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 150)
	private String descripcion;
	
	@Column(length = 50)
	private String tipo;
	
	@Column(length = 150)
	private String drive;
	
	
	
	
	public Long getIdConvenioArchivo() {
		return idConvenioArchivo;
	}




	public void setIdConvenioArchivo(Long idConvenioArchivo) {
		this.idConvenioArchivo = idConvenioArchivo;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getDrive() {
		return drive;
	}




	public void setDrive(String drive) {
		this.drive = drive;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
