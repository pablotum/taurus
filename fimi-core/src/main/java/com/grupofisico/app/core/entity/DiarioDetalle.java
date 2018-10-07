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
public class DiarioDetalle implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDiarioDetalle; 
	
	@ManyToOne
	@JoinColumn(name = "idCuentaContable")
	private CuentaContable cuentaContable;
	
	@Column
	private Float debe;
	
	@Column
	private Float haber;
	
	
	
	public Float getDebe() {
		return debe;
	}




	public void setDebe(Float debe) {
		this.debe = debe;
	}




	public Float getHaber() {
		return haber;
	}




	public void setHaber(Float haber) {
		this.haber = haber;
	}




	public Long getIdDiarioDetalle() {
		return idDiarioDetalle;
	}




	public void setIdDiarioDetalle(Long idDiarioDetalle) {
		this.idDiarioDetalle = idDiarioDetalle;
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
