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
public class CuentaContable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuentaContable;

	@Column(length = 30, nullable = false, unique = true)
	private String cuentaContable;

	@Column(length = 100, nullable = false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idClasificacionCuenta")
	private ClasificacionCuenta clasificacion;

	@ManyToOne
	@JoinColumn(name = "idUsoCuenta")
	private UsoCuenta uso;

	@ManyToOne
	@JoinColumn(name = "idFlujoCuenta")
	private FlujoCuenta flujo;

	@Column
	private Boolean bloqueo;

	public Long getIdCuentaContable() {
		return idCuentaContable;
	}

	public void setIdCuentaContable(Long idCuentaContable) {
		this.idCuentaContable = idCuentaContable;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ClasificacionCuenta getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionCuenta clasificacion) {
		this.clasificacion = clasificacion;
	}

	public UsoCuenta getUso() {
		return uso;
	}

	public void setUso(UsoCuenta uso) {
		this.uso = uso;
	}

	public FlujoCuenta getFlujo() {
		return flujo;
	}

	public void setFlujo(FlujoCuenta flujo) {
		this.flujo = flujo;
	}

	public Boolean getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(Boolean bloqueo) {
		this.bloqueo = bloqueo;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
