package com.grupofisico.app.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UsuarioEmpresa implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;
	
	@Column(length=1)
	private String estado;
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	

}
