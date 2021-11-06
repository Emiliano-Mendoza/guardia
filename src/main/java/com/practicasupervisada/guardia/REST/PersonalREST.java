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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicasupervisada.guardia.dominio.Personal;
import com.practicasupervisada.guardia.service.PersonalService;

@RestController
@RequestMapping("/api/personal")
public class PersonalREST {
	
	@Autowired
    private PersonalService personalServ;
	
	@GetMapping
    public ResponseEntity<List<Personal>> AllPersonal(){
    	return ResponseEntity.ok(personalServ.getAllPersonal());
    }
    
    @PostMapping
    public ResponseEntity<Personal> crearPersonal(@RequestBody Personal nuevo){
    	
        try {
        	Personal temp = personalServ.crearPersonal(nuevo);
        	
          	return ResponseEntity.created(new URI("/api/personal" + temp.getNroLegajo())).body(temp);
          }catch(Exception e) {
          	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
    	
    }
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Personal> borrarPersonal(@PathVariable Integer id){
    	
    	personalServ.eliminarPersonal(id);
    	
        return ResponseEntity.ok().build();
    }
}
