package com.practicasupervisada.guardia.REST;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicasupervisada.guardia.dominio.Asistencia;


@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaREST {
	
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Asistencia> AsistenciaPorId(@PathVariable Integer id){
    	return null;
    }
    
    @GetMapping(path = "/idPersonal/{id}")
    public ResponseEntity<Asistencia> AsistenciaPorIdPersonal(@PathVariable Integer id){
    	return null;
    }
    
    @GetMapping(path = "/idProveedor/{id}")
    public ResponseEntity<Asistencia> AsistenciaPorIdProveedor(@PathVariable Integer id){
    	return null;
    }
    
    @GetMapping(path = "/idVehiculo/{id}")
    public ResponseEntity<Asistencia> AsistenciaPorIdVehiculo(@PathVariable Integer id){
    	return null;
    }
    
    @GetMapping
    public ResponseEntity<List<Asistencia>> AllAsistencias(@PathVariable Integer id){
    	return null;
    }
    
    @PostMapping
    public ResponseEntity<Asistencia> crearAsistencia(@RequestBody Asistencia nuevo){
    	return null;
    }
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Asistencia> borrarAsistencia(@PathVariable Integer id){
      
        return ResponseEntity.ok().build();
    }
}
