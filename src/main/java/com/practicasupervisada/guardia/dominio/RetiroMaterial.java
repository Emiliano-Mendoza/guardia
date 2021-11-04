package com.practicasupervisada.guardia.dominio;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RetiroMaterial")
public class RetiroMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRetiro;
	private String descripcion;
	private Date fechaLimite;
	private Date fechaRetiro;
	private String observacionGuardia;
	
	@ManyToOne
	@JoinColumn(name = "ID_UsuarioGuardia")
	private UsuarioGuardia usuarioGuardia;
	@ManyToOne
	@JoinColumn(name = "ID_UsuarioSector")
	private UsuarioResponsableSector usuarioResponsableSector;
	@ManyToOne
	@JoinColumn(name = "ID_Personal")
	private Personal personal;
	
	public UsuarioGuardia getUsuarioGuardia() {
		return usuarioGuardia;
	}
	public void setUsuarioGuardia(UsuarioGuardia usuarioGuardia) {
		this.usuarioGuardia = usuarioGuardia;
	}
	public UsuarioResponsableSector getUsuarioSector() {
		return usuarioResponsableSector;
	}
	public void setUsuarioSector(UsuarioResponsableSector usuarioResponsableSector) {
		this.usuarioResponsableSector = usuarioResponsableSector;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public int getIdRetiro() {
		return idRetiro;
	}
	public void setIdRetiro(int idRetiro) {
		this.idRetiro = idRetiro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public Date getFechaRetiro() {
		return fechaRetiro;
	}
	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}
	public String getObservacionGuardia() {
		return observacionGuardia;
	}
	public void setObservacionGuardia(String observacionGuardia) {
		this.observacionGuardia = observacionGuardia;
	}
	
	
	
}
