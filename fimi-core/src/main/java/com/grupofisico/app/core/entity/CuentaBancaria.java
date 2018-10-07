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
public class CuentaBancaria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuentaBancaria;
	
	@Column(length = 100)
	private String cuentaBancaria;
	
	@Column(length = 150)
	private String descripcion;
	
	@Column
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "idTipoCuenta")
	private TipoCuenta tipoCuenta;
	
	@ManyToOne
	@JoinColumn(name = "idBanco")
	private Banco banco;
	
	@ManyToOne
	@JoinColumn(name = "idMoneda")
	private Moneda moneda;
	
	@ManyToOne
	@JoinColumn(name = "idCuentaContable")
	private CuentaContable cuentaContable;
	
	
	
	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}



	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}



	public Long getIdCuentaBancaria() {
		return idCuentaBancaria;
	}



	public void setIdCuentaBancaria(Long idCuentaBancaria) {
		this.idCuentaBancaria = idCuentaBancaria;
	}



	public String getCuentaBancaria() {
		return cuentaBancaria;
	}



	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}



	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}



	public Banco getBanco() {
		return banco;
	}



	public void setBanco(Banco banco) {
		this.banco = banco;
	}



	public Moneda getMoneda() {
		return moneda;
	}



	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
