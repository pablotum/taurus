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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Contacto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContacto;
	
	@Column(length = 20)
	private String codigo;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 100)
	private String apellido;
	
	@Column(length = 100)
	private String casada;
	
	@ManyToOne
	@JoinColumn(name = "idEstadoCivil")
	private EstadoCivil estadoCivil;
	
	@ManyToOne
	@JoinColumn(name = "idSexo")
	private Sexo sexo;
	
	@Column
	private Date fechaNacimiento;
	
	@Column(length = 150)
	private String direccion;
	
	@Column(length = 100)
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais pais;
	
	@Column
	private Boolean estado;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idContacto")
	private List<ContactoTelefono> telefonos = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idContacto")
	private List<ContactoCorreo> correos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "idProfesion")
	private Profesion profesion;
	
	
	
	public Profesion getProfesion() {
		return profesion;
	}



	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}



	public List<ContactoTelefono> getTelefonos() {
		return telefonos;
	}



	public void setTelefonos(List<ContactoTelefono> telefonos) {
		this.telefonos = telefonos;
	}



	public List<ContactoCorreo> getCorreos() {
		return correos;
	}



	public void setCorreos(List<ContactoCorreo> correos) {
		this.correos = correos;
	}



	public Long getIdContacto() {
		return idContacto;
	}



	public void setIdContacto(Long idContacto) {
		this.idContacto = idContacto;
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



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCasada() {
		return casada;
	}



	public void setCasada(String casada) {
		this.casada = casada;
	}



	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}



	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fehaNacimiento) {
		this.fechaNacimiento = fehaNacimiento;
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



	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais = pais;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
