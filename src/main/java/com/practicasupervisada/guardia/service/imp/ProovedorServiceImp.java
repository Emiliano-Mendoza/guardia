package com.practicasupervisada.guardia.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicasupervisada.guardia.dao.ProveedorRepo;
import com.practicasupervisada.guardia.dominio.Proveedor;
import com.practicasupervisada.guardia.service.ProveedorService;

@Service
public class ProovedorServiceImp implements ProveedorService {
	
	@Autowired
	private ProveedorRepo proveedorRepo;
	
	@Override
	public Proveedor crearPersonal(Proveedor p) {
		return proveedorRepo.save(p);
	}

	@Override
	public List<Proveedor> getAllProveedores() {
		return proveedorRepo.findAll();
	}

	@Override
	public void eliminarProveedor(int idProveedor) {
		proveedorRepo.deleteById(idProveedor);

	}

	@Override
	public Optional<Proveedor> findById(int idProveedor) {
		return proveedorRepo.findById(idProveedor);
	}

}
