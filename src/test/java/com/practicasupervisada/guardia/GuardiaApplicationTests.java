package com.practicasupervisada.guardia;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.practicasupervisada.guardia.dao.UsuarioRepo;
import com.practicasupervisada.guardia.dominio.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuardiaApplication.class)
class GuardiaApplicationTests {
	
	@Autowired
	private UsuarioRepo repo;
	
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setIdUsuario(2);
		us.setUsuario("emi123");
		us.setContraseña(new BCryptPasswordEncoder().encode("1234"));		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getContraseña().equalsIgnoreCase(us.getContraseña()));
	}

}
