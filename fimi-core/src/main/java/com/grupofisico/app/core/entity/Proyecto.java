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
public class Proyecto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyecto;
	
	@Column(length = 50, unique = true)
	private String codigo;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 150)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idEntidad")
	private Entidad entidad;
	
	@Column
	private Date inicio;
	
	@Column
	private Date fin;
	
	@ManyToOne
	@JoinColumn(name = "idMoneda")
	private Moneda moneda;
	
	@ManyToOne
	@JoinColumn(name = "idConvenio")
	private Convenio convenio;
	
	@Column
	private Float monto;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProyecto")
	private List<ProyectoActividad> actividades = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProyecto")
	private List<ProyectoRubro> rubros = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProyecto")
	private List<ProyectoDesembolso> desembolsos = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProyecto")
	private List<ProyectoArchivo> archivos = new ArrayList<>();
	
	

	public Long getIdProyecto() {
		return idProyecto;
	}



	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
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



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Entidad getEntidad() {
		return entidad;
	}



	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}



	public Date getInicio() {
		return inicio;
	}



	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}



	public Date getFin() {
		return fin;
	}



	public void setFin(Date fin) {
		this.fin = fin;
	}



	public Moneda getMoneda() {
		return moneda;
	}



	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}



	public Convenio getConvenio() {
		return convenio;
	}



	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}



	public Float getMonto() {
		return monto;
	}



	public void setMonto(Float monto) {
		this.monto = monto;
	}



	public List<ProyectoActividad> getActividades() {
		return actividades;
	}



	public void setActividades(List<ProyectoActividad> actividades) {
		this.actividades = actividades;
	}



	public List<ProyectoRubro> getRubros() {
		return rubros;
	}



	public void setRubros(List<ProyectoRubro> rubros) {
		this.rubros = rubros;
	}



	public List<ProyectoDesembolso> getDesembolsos() {
		return desembolsos;
	}



	public void setDesembolsos(List<ProyectoDesembolso> desembolsos) {
		this.desembolsos = desembolsos;
	}



	public List<ProyectoArchivo> getArchivos() {
		return archivos;
	}



	public void setArchivos(List<ProyectoArchivo> archivos) {
		this.archivos = archivos;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
