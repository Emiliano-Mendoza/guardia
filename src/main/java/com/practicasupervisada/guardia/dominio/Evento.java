package com.practicasupervisada.guardia.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	private String descripcion;
	private Date fechaEvento;
	private String observacionDeGuardia;
	private Boolean ocurrencia;
	
	@ManyToOne
	@JoinColumn(name = "ID_UsuarioSector")
	private UsuarioResponsableSector usuarioResponsableSector;
	
	@ManyToOne
	@JoinColumn(name = "ID_UsuarioGuardia")
	private UsuarioGuardia usurioGuardia;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public String getObservacionDeGuardia() {
		return observacionDeGuardia;
	}
	public void setObservacionDeGuardia(String observacionDeGuardia) {
		this.observacionDeGuardia = observacionDeGuardia;
	}
	public Boolean getOcurrencia() {
		return ocurrencia;
	}
	public void setOcurrencia(Boolean ocurrencia) {
		this.ocurrencia = ocurrencia;
	}
	public UsuarioResponsableSector getUsuarioSector() {
		return usuarioResponsableSector;
	}
	public void setUsuarioSector(UsuarioResponsableSector usuarioResponsableSector) {
		this.usuarioResponsableSector = usuarioResponsableSector;
	}
	public UsuarioGuardia getUsurioGuardia() {
		return usurioGuardia;
	}
	public void setUsurioGuardia(UsuarioGuardia usurioGuardia) {
		this.usurioGuardia = usurioGuardia;
	}
	
	
	
}
