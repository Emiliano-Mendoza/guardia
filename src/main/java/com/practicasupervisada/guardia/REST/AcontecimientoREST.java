package com.practicasupervisada.guardia.REST;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicasupervisada.guardia.dominio.Acontecimiento;
import com.practicasupervisada.guardia.service.AcontecimientoService;

@RestController
@RequestMapping("/api/acontecimiento")
public class AcontecimientoREST {
	
	@Autowired
    private AcontecimientoService aconServ;
	
	@GetMapping
    public ResponseEntity<List<Acontecimiento>> AllAcontecimiento(){
    	return ResponseEntity.ok(aconServ.getAllAcontecimientos());
    }
	
    @PostMapping
    public ResponseEntity<Acontecimiento> crearAcontecimiento(@RequestBody Acontecimiento nuevo){
    	
        try {
        	nuevo.setFecha(new Date());
        	
        	Acontecimiento temp = aconServ.crearAcontecimiento(nuevo);
        	
          	return ResponseEntity.created(new URI("/api/acontecimiento" + temp.getIdAcontencimiento())).body(temp);
          }catch(Exception e) {
          	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
    	
    }
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Acontecimiento> borrarAcontecimiento(@PathVariable Integer id){
    	
    	aconServ.eliminarAcontecimiento(id);
    	
        return ResponseEntity.ok().build();
    }
}
