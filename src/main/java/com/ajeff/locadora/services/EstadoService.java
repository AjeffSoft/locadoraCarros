package com.ajeff.locadora.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ajeff.locadora.domain.Estado;
import com.ajeff.locadora.exceptions.DatabaseIntegrityException;
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
	
	public Estado salvar(Estado obj) {
		return repository.save(obj);
	}
	
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseIntegrityException(e.getMessage());
		}
	}
	
	public Estado alterar(Long id, Estado obj) {
		try {
			Estado est = repository.getOne(id);
			update(est, obj);
			return repository.save(est);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	private void update(Estado est, Estado obj) {
		est.setNome(obj.getNome());
		
	}
}
