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
public class Entidad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntidad;
	
	@Column(length = 50)
	private String codigo;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 150)
	private String direccion;
	
	@Column(length = 150)
	private String ciudad;
		
	@Column(length = 100)
	private String telefono;
	
	@Column(length = 100)
	private String correo;
	
	@Column(length = 15)
	private String postal;
	
	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais pais;
	
	
	
	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais = pais;
	}



	public Long getIdEntidad() {
		return idEntidad;
	}



	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getPostal() {
		return postal;
	}



	public void setPostal(String postal) {
		this.postal = postal;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
