package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Asistencia;

public interface AsistenciaRepo extends JpaRepository<Asistencia, Integer> {
	
}
