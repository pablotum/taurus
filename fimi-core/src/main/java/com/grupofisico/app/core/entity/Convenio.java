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
public class Convenio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvenio;
	
	@Column(length = 50, unique = true)
	private String codigo;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 150)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idDonante")
	private Donante donante;
	
	@Column
	private Date inicio;
	
	@Column
	private Date fin;
	
	@ManyToOne
	@JoinColumn(name = "idMoneda")
	private Moneda moneda;
	
	@Column
	private Float monto;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idConvenio")
	private List<ConvenioActividad> actividades = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idConvenio")
	private List<ConvenioRubro> rubros = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idConvenio")
	private List<ConvenioDesembolso> desembolsos = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idConvenio")
	private List<ConvenioArchivo> archivos = new ArrayList<>();
	
	
	public List<ConvenioArchivo> getArchivos() {
		return archivos;
	}

	public void setArchivos(List<ConvenioArchivo> archivos) {
		this.archivos = archivos;
	}

	public List<ConvenioDesembolso> getDesembolsos() {
		return desembolsos;
	}

	public void setDesembolsos(List<ConvenioDesembolso> desembolsos) {
		this.desembolsos = desembolsos;
	}

	public List<ConvenioActividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<ConvenioActividad> actividades) {
		this.actividades = actividades;
	}

	public List<ConvenioRubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<ConvenioRubro> rubros) {
		this.rubros = rubros;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Long getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Long idConvenio) {
		this.idConvenio = idConvenio;
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

	public Donante getDonante() {
		return donante;
	}

	public void setDonante(Donante donante) {
		this.donante = donante;
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

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}
	
	
	
}
