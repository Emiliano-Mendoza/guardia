package com.practicasupervisada.guardia.service;

import java.util.List;
import java.util.Optional;

import com.practicasupervisada.guardia.dominio.Proveedor;

public interface ProveedorService {
	
	public Proveedor crearProveedor(Proveedor p);
	public List<Proveedor> getAllProveedor();
	public void eliminarProveedor(int idProveedor);
	public Optional<Proveedor> findById(int idProveedor);
	
}
