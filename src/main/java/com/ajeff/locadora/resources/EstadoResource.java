package com.ajeff.locadora.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajeff.locadora.domain.Estado;
import com.ajeff.locadora.servicies.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> lista(){
		List<Estado> list = service.lista();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findOne(@PathVariable Long id){
		Estado obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
