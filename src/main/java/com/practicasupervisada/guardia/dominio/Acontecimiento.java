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
@Table(name="Acontecimiento")
public class Acontecimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAcontencimiento;
	private Date fecha;
	private String ronda;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "ID_UsuarioGuardia")
	private UsuarioGuardia usuario;
	
	public Acontecimiento(Date fecha, String ronda, String descripcion) {
		super();
		this.fecha = fecha;
		this.ronda = ronda;
		this.descripcion = descripcion;
	}
	public int getIdAcontencimiento() {
		return idAcontencimiento;
	}
	public void setIdAcontencimiento(int idAcontencimiento) {
		this.idAcontencimiento = idAcontencimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getRonda() {
		return ronda;
	}
	public void setRonda(String ronda) {
		this.ronda = ronda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public UsuarioGuardia getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioGuardia usuario) {
		this.usuario = usuario;
	}
	
	
}
