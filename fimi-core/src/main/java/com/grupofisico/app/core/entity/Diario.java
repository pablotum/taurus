package com.grupofisico.app.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Diario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long asiento;
	
	@Column
	private Date fecha;
	
	@Column(length = 100)
	private String descripcion;
	
	@Column(length = 100)
	private String codigo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "asiento")
	private List<DiarioDetalle> detalle = new ArrayList<>();
	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public List<DiarioDetalle> getDetalle() {
		return detalle;
	}



	public void setDetalle(List<DiarioDetalle> detalle) {
		this.detalle = detalle;
	}



	public Long getAsiento() {
		return asiento;
	}



	public void setAsiento(Long asiento) {
		this.asiento = asiento;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
