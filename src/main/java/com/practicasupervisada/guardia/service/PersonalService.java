package com.practicasupervisada.guardia.service;

import java.util.List;
import java.util.Optional;

import com.practicasupervisada.guardia.dominio.Personal;

public interface PersonalService {
	
	public Personal crearPersonal(Personal p);
	public List<Personal> getAllPersonal();
	public void eliminarPersonal(int idPersonal);
	public Optional<Personal> findById(int idPersonal);
}
