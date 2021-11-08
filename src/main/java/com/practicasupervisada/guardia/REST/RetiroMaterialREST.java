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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicasupervisada.guardia.dominio.RetiroMaterial;
import com.practicasupervisada.guardia.service.RetiroMaterialService;

@RestController
@RequestMapping("/api/retiro_material")
public class RetiroMaterialREST {
	
	@Autowired
    private RetiroMaterialService retiroServ;
	
	@GetMapping
    public ResponseEntity<List<RetiroMaterial>> AllRetiroMaterial(){
    	return ResponseEntity.ok(retiroServ.getAllRetiroMaterial());
    }
    
    @PostMapping(path = "/autorizacion")
    public ResponseEntity<RetiroMaterial> crearAutorizacionRetiroMaterial(@RequestBody RetiroMaterial nuevo){
    	
        try {
        	
        	if(nuevo.getUsuarioGuardia() != null || nuevo.getFechaRetiro() != null ||
        			nuevo.getObservacionGuardia() != null) {
        		throw new Exception("Campos inválidos");
        	}

        	RetiroMaterial temp = retiroServ.crearRetiroMaterial(nuevo);
        	
          	return ResponseEntity.created(new URI("/api/personal" + temp.getIdRetiro())).body(temp);
          }catch(Exception e) {
          	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }    	
    }
    
    @PutMapping(path = "/retiro")
    public ResponseEntity<RetiroMaterial> retirarMaterial(@RequestBody RetiroMaterial nuevo){
    	 	
    	try {
    		RetiroMaterial temp = retiroServ.findById(nuevo.getIdRetiro()).get();
    		temp.setFechaRetiro(new Date());
    		temp.setObservacionGuardia(nuevo.getObservacionGuardia());
    		temp.setUsuarioGuardia(nuevo.getUsuarioGuardia());
    		
    		return ResponseEntity.ok(retiroServ.crearRetiroMaterial(temp));
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    }
    
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<RetiroMaterial> borrarRetiroMaterial(@PathVariable Integer id){
    	
    	retiroServ.eliminarRetiroMaterial(id);
    	
        return ResponseEntity.ok().build();
    }
}
