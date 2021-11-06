package com.practicasupervisada.guardia.service;

import java.util.List;
import java.util.Optional;

import com.practicasupervisada.guardia.dominio.Asistencia;
import com.practicasupervisada.guardia.dominio.Personal;
import com.practicasupervisada.guardia.dominio.Proveedor;

public interface AsistenciaService {
	
	public Asistencia crearAsistencia(Asistencia asis);
	public List<Asistencia> getAllAsistencias();
	public void eliminarAsistencia(int idAsistencia);
	public Optional<Asistencia> findById(int idAsistencia);
	//public Optional<Asistencia> findByPersonal(Personal personal);
	//public Optional<Asistencia> findByPersonal(Proveedor proveedor);
}
