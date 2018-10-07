package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pais implements Serializable {

	@Id
	private Integer idPais;
	
	@Column(length = 100)
	@NotNull
	private String pais;
	
	@Column(length = 20)
	private String codigo;
	
	
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Integer getIdPais() {
		return idPais;
	}


	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
