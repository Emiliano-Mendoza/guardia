package com.practicasupervisada.guardia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicasupervisada.guardia.dominio.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

	Usuario findByUsuario(String us);
	
}
