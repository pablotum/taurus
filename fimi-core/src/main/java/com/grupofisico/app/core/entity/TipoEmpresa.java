package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TipoEmpresa implements Serializable {

	@Id
	private Integer idTipoEmpresa;
	
	@Column(length=100)
	@NotNull
	private String tipoEmpresa;
	
	
	public Integer getIdTipoEmpresa() {
		return idTipoEmpresa;
	}


	public void setIdTipoEmpresa(Integer idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}


	public String getTipoEmpresa() {
		return tipoEmpresa;
	}


	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
