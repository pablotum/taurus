package com.grupofisico.app.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PeriodoDetalle implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPeriodoDetalle;
	
	
	@Column(length = 100, nullable= false)
	private String descripcion;
	
	@Column
	private Date inicia;
	
	@Column 
	private Integer estado;
	
	
	
	public Integer getEstado() {
		return estado;
	}



	public void setEstado(Integer estado) {
		this.estado = estado;
	}



	public Long getIdPeriodoDetalle() {
		return idPeriodoDetalle;
	}



	public void setIdPeriodoDetalle(Long idPeriodoDetalle) {
		this.idPeriodoDetalle = idPeriodoDetalle;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Date getInicia() {
		return inicia;
	}



	public void setInicia(Date inicia) {
		this.inicia = inicia;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
