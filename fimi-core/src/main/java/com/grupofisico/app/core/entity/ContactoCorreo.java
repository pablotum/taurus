package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactoCorreo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContactoCorreo;
	
	@Column(length = 100)
	private String correo;
	
	@Column(length = 150)
	private String observacion;
	
	/*
	 * 1 Personal
	 * 2 Trabajo
	 */
	@Column
	private Integer tipo;
	
	@Column
	private Boolean estado;
	
	
	
	public Long getIdContactoCorreo() {
		return idContactoCorreo;
	}



	public void setIdContactoCorreo(Long idContactoCorreo) {
		this.idContactoCorreo = idContactoCorreo;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
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
