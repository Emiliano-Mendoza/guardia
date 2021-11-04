package com.practicasupervisada.guardia.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Proveedor{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	private String razonSocial;
	
	public Proveedor(String razonSocial) {
		super();
		this.razonSocial = razonSocial;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
}
