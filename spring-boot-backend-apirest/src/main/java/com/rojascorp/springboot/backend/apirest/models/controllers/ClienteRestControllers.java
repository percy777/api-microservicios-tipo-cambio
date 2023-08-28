package com.rojascorp.springboot.backend.apirest.models.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rojascorp.springboot.backend.apirest.models.entity.Moneda;
import com.rojascorp.springboot.backend.apirest.models.service.IClienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteRestControllers {
	
	@Autowired
	private IClienteService iClienteService; 
	
	@GetMapping("/tipoCambio")
	public List<Moneda> index(){
		return iClienteService.listar();
	}
	
	@GetMapping("/tipoCambio/{id}")
	public ResponseEntity<?> buscarxId(@PathVariable Long id){
		
		Map<String, Object> response = new HashMap<>();
		Moneda moneda = null;
		try {
			
			moneda = iClienteService.buscarPorId(id);
			if(moneda == null) {
				response.put("mensaje", "no se encontro registro para el id: " +id+ " en la base de datos");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);	
			}
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("message", "Error al realizar la consulta a la base de datos");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Moneda>(moneda,HttpStatus.OK);
	}
	
	@PostMapping("/tipoCambio")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> guardar(@RequestBody Moneda moneda){
		Map<String, Object> response = new HashMap<>();
		Moneda mo = null;
		try {
			mo = iClienteService.guardar(moneda);
			
			if(mo == null) {
				response.put("mensaje", "no se encontro registro");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "error de acceso a la BD");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "se encontro registro");
		response.put("moneda", mo);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/tipoCambio/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id) throws DataAccessException{
		Map<String, Object> response = new HashMap<>();
		try {
			
			iClienteService.borrar(id);
			response.put("mensaje", "se elimino correctamente");
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "No se pudo eliminar");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}

}
