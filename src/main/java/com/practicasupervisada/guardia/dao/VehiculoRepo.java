package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Vehiculo;

public interface VehiculoRepo extends JpaRepository<Vehiculo, Integer> {

}
