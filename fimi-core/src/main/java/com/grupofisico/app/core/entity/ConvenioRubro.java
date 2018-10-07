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
public class ConvenioRubro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvenioRubro;
	
	@ManyToOne
	@JoinColumn(name = "idRubro")
	private Rubro rubro;
	
	@Column(length = 150)
	private String descripcion;
	
	@Column
	private Float monto;
	
	
	
	public Long getIdConvenioRubro() {
		return idConvenioRubro;
	}



	public void setIdConvenioRubro(Long idConvenioRubro) {
		this.idConvenioRubro = idConvenioRubro;
	}



	public Rubro getRubro() {
		return rubro;
	}



	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Float getMonto() {
		return monto;
	}



	public void setMonto(Float monto) {
		this.monto = monto;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
