package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Acontecimiento;

public interface AcontecimientoRepo extends JpaRepository<Acontecimiento, Integer> {

}
