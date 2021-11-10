package com.practicasupervisada.guardia.REST;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicasupervisada.guardia.dominio.Usuario;
import com.practicasupervisada.guardia.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioREST {
	
	@Autowired
    private UsuarioService usuarioServ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
    public ResponseEntity<List<Usuario>> AllUsuario(){
    	return ResponseEntity.ok(usuarioServ.getAllUsuario());
    }
	
	@GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<Usuario>> UsuarioPorId(@PathVariable Integer id){
    	return ResponseEntity.ok(usuarioServ.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario nuevo){
    	
        try {
        	Usuario temp = usuarioServ.crearUsuario(nuevo);
        	
          	return ResponseEntity.created(new URI("/api/usuario" + temp.getIdUsuario())).body(temp);
          }catch(Exception e) {
          	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
    	
    }
	
}
