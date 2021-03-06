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

import com.practicasupervisada.guardia.dominio.Proveedor;
import com.practicasupervisada.guardia.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorREST {
	
	@Autowired
    private ProveedorService proveedorServ;
	
	@GetMapping
    public ResponseEntity<List<Proveedor>> AllProveedor(){
    	return ResponseEntity.ok(proveedorServ.getAllProveedor());
    }
    
    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor nuevo){
    	
        try {
        	Proveedor temp = proveedorServ.crearProveedor(nuevo);
        	
          	return ResponseEntity.created(new URI("/api/proveedor" + temp.getIdProveedor())).body(temp);
          }catch(Exception e) {
          	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
    	
    }
    
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Proveedor> borrarProveedor(@PathVariable Integer id){
    	
    	proveedorServ.eliminarProveedor(id);
    	
        return ResponseEntity.ok().build();
    }
}
