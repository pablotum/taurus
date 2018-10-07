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
public class TipoDocumento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoDocumento;
	
	@Column(length = 100)
	private String tipoDocumento;
	
	@Column(length = 150)
	private String descripcion;
	
	@Column
	private Boolean estado;
	
	@Column(length = 3)
	private String abreviatura;
	
	@ManyToOne
	@JoinColumn(name = "idCuentaBancaria")
	private CuentaBancaria cuentaBancaria;
	
	@Column
	// 1 Debe; 2 Haber
	private Integer operacion;
	
	@ManyToOne
	@JoinColumn(name = "idCuentaContable")
	private CuentaContable cuentaContable;
	
	@ManyToOne
	@JoinColumn(name = "idContraPartida")
	private CuentaContable contraPartida;
	
	
	
	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}



	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public String getAbreviatura() {
		return abreviatura;
	}



	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}



	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}



	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}



	public Integer getOperacion() {
		return operacion;
	}



	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}



	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}



	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}



	public CuentaContable getContraPartida() {
		return contraPartida;
	}



	public void setContraPartida(CuentaContable contraPartida) {
		this.contraPartida = contraPartida;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
