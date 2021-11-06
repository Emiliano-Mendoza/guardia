package com.practicasupervisada.guardia.REST;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practicasupervisada.guardia.dominio.Asistencia;
import com.practicasupervisada.guardia.service.AsistenciaService;
import com.practicasupervisada.guardia.service.PersonalService;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaREST {
	
	@Autowired
    private AsistenciaService asisServ;
	
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<Asistencia>> AsistenciaPorId(@PathVariable Integer id){
    	return ResponseEntity.ok(asisServ.findById(id));
    }
    
    @GetMapping(path = "/idPersonal/{id}")
    public ResponseEntity<Stream<Asistencia>> AsistenciaPorIdPersonal(@PathVariable Integer id){
    			
    	try {  		
    		Stream <Asistencia> stream = asisServ.getAllAsistencias().stream()
    										.filter(asis -> asis.getPersonal().getNroLegajo() == id);
    		
    		return ResponseEntity.ok(stream);
    		 
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	 	
    }
    
    @GetMapping(path = "/idProveedor/{id}")
    public ResponseEntity<Stream<Asistencia>> AsistenciaPorIdProveedor(@PathVariable Integer id){
    	try {  		
    		Stream <Asistencia> stream = asisServ.getAllAsistencias().stream()
    										.filter(asis -> asis.getPersonal().getNroLegajo() == id);
    		
    		return ResponseEntity.ok(stream);
    		 
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    }
    
    @GetMapping(path = "/idVehiculo/{id}")
    public ResponseEntity<Asistencia> AsistenciaPorIdVehiculo(@PathVariable Integer id){
    	return null;
    }
    
    @GetMapping
    public ResponseEntity<List<Asistencia>> AllAsistencias(){
    	return ResponseEntity.ok(asisServ.getAllAsistencias());
    }
    
    @PostMapping(path = "/entrada")
    public ResponseEntity<Asistencia> crearAsistencia(@RequestBody Asistencia nuevo){
    	
    	nuevo.setEntrada(new Date());
    	
    	try {
    		Asistencia temp = asisServ.crearAsistencia(nuevo);
    		return ResponseEntity.created(new URI("/api/asistencia" + temp.getIdAsistencia())).body(temp);
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    }
    @PutMapping(path = "/salida")
    public ResponseEntity<Asistencia> agregarSalidaAsistencia(@RequestBody Asistencia nuevo){
    	 	
    	try {
    		Asistencia temp = asisServ.findById(nuevo.getIdAsistencia()).get();
    		temp.setSalida(new Date());
    		
    		return ResponseEntity.ok(asisServ.crearAsistencia(temp));
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    }
    
    @PutMapping(path = "/transito")
    public ResponseEntity<Asistencia> enTransito(@RequestBody Asistencia nuevo){
    		
    	try {    		
    		Asistencia temp = asisServ.findById(nuevo.getIdAsistencia()).get();
    		
    		
        	if(temp.getEnTransito()) temp.setEnTransito(false);
        	else temp.setEnTransito(true);
    		
    		return ResponseEntity.ok(asisServ.crearAsistencia(temp));
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    }
    
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Asistencia> borrarAsistencia(@PathVariable Integer id){
    	
    	asisServ.eliminarAsistencia(id);
    	
        return ResponseEntity.ok().build();
    }
}
