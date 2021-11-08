package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Evento;

public interface EventoRepo extends JpaRepository<Evento, Integer> {

}
