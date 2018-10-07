package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sexo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSexo;
	
	@Column(length = 10)
	private String codigo;
	
	@Column(length = 20)
	private String sexo;
	
	
	
	public Long getIdSexo() {
		return idSexo;
	}



	public void setIdSexo(Long idSexo) {
		this.idSexo = idSexo;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
