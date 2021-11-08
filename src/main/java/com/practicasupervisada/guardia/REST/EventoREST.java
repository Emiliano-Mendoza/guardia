package com.practicasupervisada.guardia.REST;

import java.net.URI;
import java.util.List;

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

import com.practicasupervisada.guardia.dominio.Evento;
import com.practicasupervisada.guardia.service.EventoService;

@RestController
@RequestMapping("/api/evento")
public class EventoREST {
	
	@Autowired
	private EventoService eventoServ;
	
	@GetMapping
    public ResponseEntity<List<Evento>> AllRetiroEvento(){
    	return ResponseEntity.ok(eventoServ.getAllEvento());
    }
	
    @PostMapping(path = "/aviso_evento")
    public ResponseEntity<Evento> crearAvisoEvento(@RequestBody Evento nuevo){
    	
        try {
        	
        	//La fecha del evento la ingresa el usuario de sector
        	if(nuevo.getUsurioGuardia() != null || nuevo.getObservacionDeGuardia() != null) {
        		throw new Exception("Campos inválidos");
        	}
        	
        	nuevo.setOcurrencia(false);
        	Evento temp = eventoServ.crearEvento(nuevo);
        	
          	return ResponseEntity.created(new URI("/api/personal" + temp.getIdEvento())).body(temp);
          }catch(Exception e) {
          	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }    	
    }
    
    @PutMapping(path = "/ocurrencia_evento")
    public ResponseEntity<Evento> ocurrenciaEvento(@RequestBody Evento nuevo){
    	 	
    	try {
    		Evento temp = eventoServ.findById(nuevo.getIdEvento()).get();
    		temp.setObservacionDeGuardia(nuevo.getObservacionDeGuardia());
    		temp.setUsurioGuardia(nuevo.getUsurioGuardia());
    		temp.setOcurrencia(true);
    		
    		return ResponseEntity.ok(eventoServ.crearEvento(temp));
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    }
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Evento> borrarEvento(@PathVariable Integer id){
    	
    	eventoServ.eliminarEvento(id);
    	
        return ResponseEntity.ok().build();
    }
	
}
