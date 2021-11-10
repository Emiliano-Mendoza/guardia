package com.practicasupervisada.guardia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practicasupervisada.guardia.dao.AsistenciaRepo;
import com.practicasupervisada.guardia.dominio.Asistencia;
import com.practicasupervisada.guardia.service.AsistenciaService;

@Service
public class AsistenciaServiceImp implements AsistenciaService {
	
	@Autowired
	private AsistenciaRepo asistenciaRepo;
	
	@Override
	public Asistencia crearAsistencia(Asistencia asis) {		
		return asistenciaRepo.save(asis);
	}

	@Override
	public List<Asistencia> getAllAsistencias() {
		return asistenciaRepo.findAll();
	}

	@Override
	public void eliminarAsistencia(int idAsistencia) {
		asistenciaRepo.deleteById(idAsistencia);

	}

	@Override
	public Optional<Asistencia> findById(int idAsistencia) {
		return asistenciaRepo.findById(idAsistencia);
	}

/*
	@Override
	public Optional<Asistencia> findByPersonal(Proveedor proveedor) {
		return asistenciaRepo.findByProveedor(proveedor);
	}
*/
}
