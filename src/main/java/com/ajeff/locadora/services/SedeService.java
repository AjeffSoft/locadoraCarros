package com.ajeff.locadora.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ajeff.locadora.domain.Sede;
import com.ajeff.locadora.exceptions.DatabaseIntegrityException;
import com.ajeff.locadora.exceptions.ObjectNotFoundException;
import com.ajeff.locadora.repositories.SedeRepository;

@Service
public class SedeService {
	
	@Autowired
	private SedeRepository repository;
	
	
	public List<Sede> lista(){
		return repository.findAll();
	}
	
	public Sede buscar(Long id) {
		Optional<Sede> entity = repository.findById(id);
		return entity.orElseThrow(()-> new ObjectNotFoundException(id));
	}
	
	public Sede salvar(Sede entity) {
		return repository.save(entity);
	}
	
	public void excluir (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseIntegrityException(e.getMessage());
		}
	}
	
	public Sede alterar (Long id, Sede obj) {
		try {
			Sede entity = repository.getOne(id);
			update(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	private void update(Sede entity, Sede obj) {
		entity.setS(obj.getS());
		entity.setW(obj.getW());
	}
	
	

}
