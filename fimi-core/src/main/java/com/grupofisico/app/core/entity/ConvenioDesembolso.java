package com.grupofisico.app.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConvenioDesembolso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvenioDesembolso;
	
	@Column(length = 100)
	private String descripcion;
	
	@Column(length = 100)
	private Float monto;
	
	@Column
	private Date fecha;
	
	@Column
	private Boolean estado;
	
	@Column
	private Date FechaDesembolso;
	
	
	
	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public Date getFechaDesembolso() {
		return FechaDesembolso;
	}



	public void setFechaDesembolso(Date fechaDesembolso) {
		FechaDesembolso = fechaDesembolso;
	}



	public Long getIdConvenioDesembolso() {
		return idConvenioDesembolso;
	}



	public void setIdConvenioDesembolso(Long idConvenioDesembolso) {
		this.idConvenioDesembolso = idConvenioDesembolso;
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



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
