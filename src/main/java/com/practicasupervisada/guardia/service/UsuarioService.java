package com.practicasupervisada.guardia.service;

import java.util.List;
import java.util.Optional;

import com.practicasupervisada.guardia.dominio.Usuario;

public interface UsuarioService {
	
	public Usuario crearUsuario(Usuario us);
	public List<Usuario> getAllUsuario();
	public Optional<Usuario> findById(int idUsuario);
	public Usuario findByUsuario(String us);
	
}
