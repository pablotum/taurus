package com.grupofisico.app.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Periodo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPeriodo;

	@Column
	private Integer anio;

	@Column(length = 100, nullable = false)
	private String descripcion;

	@Column
	private Float tasa;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPeriodo")
	private List<PeriodoDetalle> detalle = new ArrayList<>();

	public List<PeriodoDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<PeriodoDetalle> detalle) {
		this.detalle = detalle;
	}

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getTasa() {
		return tasa;
	}

	public void setTasa(Float tasa) {
		this.tasa = tasa;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
