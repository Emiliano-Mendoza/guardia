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
@Table(name="Asistencia")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsistencia;
	private Date entrada;
	private Date salida;
	private Boolean enTransito;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_Usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_Personal")
	private Personal personal;
	
	@ManyToOne
	@JoinColumn(name = "id_Proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_Vehiculo")
	private Vehiculo vehiculo;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public int getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	public Boolean getEnTransito() {
		return enTransito;
	}
	public void setEnTransito(Boolean enTransito) {
		this.enTransito = enTransito;
	}
	
	
}
