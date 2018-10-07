package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa implements Serializable {

	@Id
	private Integer idEmpresa;

	@Column(length = 30)
	private String codigo;
	
	@Column(length = 100)
	@NotNull
	private String nombre;

	@Column(length = 100)
	private String razon;
	
	@Column(length = 50)
	private String nit;
	
	@Column
	private Boolean estado;
	
	@Column(length = 150)
	private String direccion;

	@Column(length = 100)
	private String colonia;

	@Column(length = 100)
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name = "idTipoEmpresa")
	private TipoEmpresa tipoEmpresa;
	
	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais pais;
	
	

	public String getColonia() {
		return colonia;
	}



	public void setColonia(String colonia) {
		this.colonia = colonia;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getNit() {
		return nit;
	}



	public void setNit(String nit) {
		this.nit = nit;
	}



	public Integer getIdEmpresa() {
		return idEmpresa;
	}



	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getRazon() {
		return razon;
	}



	public void setRazon(String razon) {
		this.razon = razon;
	}



	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}



	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}



	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais = pais;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
