package com.practicasupervisada.guardia.service;

import java.util.List;
import java.util.Optional;

import com.practicasupervisada.guardia.dominio.Asistencia;

public interface AsistenciaService {
	
	public Asistencia crearAsistencia(Asistencia asis);
	public List<Asistencia> getAllAsistencias();
	public void eliminarAsistencia(int idAsistencia);
	public Optional<Asistencia> findById(int idAsistencia);
}
