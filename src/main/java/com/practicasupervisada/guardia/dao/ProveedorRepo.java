package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Proveedor;

public interface ProveedorRepo extends JpaRepository<Proveedor, Integer> {

}
