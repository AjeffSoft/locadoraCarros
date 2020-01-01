package com.ajeff.locadora.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajeff.locadora.domain.Estado;
import com.ajeff.locadora.exceptions.ObjectNotFoundException;
import com.ajeff.locadora.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> lista(){
		return repository.findAll();
	}

	public Estado buscar(Long id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id));
	}
}
