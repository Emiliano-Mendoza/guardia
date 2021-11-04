package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Personal;

public interface PersonalRepo extends JpaRepository<Personal, Integer> {

}
