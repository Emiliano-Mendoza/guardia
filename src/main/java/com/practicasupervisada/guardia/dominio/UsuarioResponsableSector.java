package com.practicasupervisada.guardia.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Sector")
public class UsuarioResponsableSector extends Usuario {
	
	private String sector;
	
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}	
	
}
