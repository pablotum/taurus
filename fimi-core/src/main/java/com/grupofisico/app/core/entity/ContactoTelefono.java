package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactoTelefono implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContactoTelefono;
	
	@Column(length = 20)
	private String telefono;
	
	@Column(length = 20)
	private String extension;
	
	@Column(length = 100)
	private String observacion;
	
	/*
	 * 1 Movil
	 * 2 casa
	 * 3 oficina
	 */
	@Column
	private Integer tipo;
	
	@Column
	private Boolean estado;

	
	
	public Long getIdContactoTelefono() {
		return idContactoTelefono;
	}



	public void setIdContactoTelefono(Long idContactoTelefono) {
		this.idContactoTelefono = idContactoTelefono;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getExtension() {
		return extension;
	}



	public void setExtension(String extension) {
		this.extension = extension;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	public Integer getTipo() {
		return tipo;
	}



	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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
