package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profesion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfesion;
	
	@Column(length = 10)
	private String codigo;
	
	@Column(length = 100)
	private String profesion;
	
	
	
	public Long getIdProfesion() {
		return idProfesion;
	}



	public void setIdProfesion(Long idProfesion) {
		this.idProfesion = idProfesion;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
