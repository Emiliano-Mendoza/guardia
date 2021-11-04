package com.practicasupervisada.guardia.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Guardia")
public class UsuarioGuardia extends Usuario {

	
}
