package com.ajeff.locadora.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ajeff.locadora.domain.Cliente;
import com.ajeff.locadora.exceptions.DatabaseIntegrityException;
import com.ajeff.locadora.exceptions.ObjectNotFoundException;
import com.ajeff.locadora.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	
	public List<Cliente> lista(){
		return repository.findAll();
	}
	
	public Cliente buscar(Long id) {
		Optional<Cliente> entity = repository.findById(id);
		return entity.orElseThrow(()-> new ObjectNotFoundException(id));
	}
	
	public Cliente salvar(Cliente entity) {
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
	
	public Cliente alterar (Long id, Cliente obj) {
		try {
			Cliente entity = repository.getOne(id);
			update(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	private void update(Cliente entity, Cliente obj) {
		entity.setCpf(obj.getCpf());
		entity.setEmail(obj.getEmail());
		entity.setNome(obj.getNome());

	}
	
	

}
