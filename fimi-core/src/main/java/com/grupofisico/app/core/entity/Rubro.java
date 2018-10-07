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
public class Rubro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRubro;
	
	@Column(length = 10, unique = true)
	private String codigo;
	
	@Column(length = 100)
	private String rubro;
	
	@Column(length = 150)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idCuentaContable")
	private CuentaContable cuentaContable;
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Long getIdRubro() {
		return idRubro;
	}



	public void setIdRubro(Long idRubro) {
		this.idRubro = idRubro;
	}



	public String getRubro() {
		return rubro;
	}



	public void setRubro(String rubro) {
		this.rubro = rubro;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}



	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
