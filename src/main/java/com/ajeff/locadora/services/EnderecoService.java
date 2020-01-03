package com.ajeff.locadora.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ajeff.locadora.domain.Endereco;
import com.ajeff.locadora.exceptions.DatabaseIntegrityException;
import com.ajeff.locadora.exceptions.ObjectNotFoundException;
import com.ajeff.locadora.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	
	public List<Endereco> lista(){
		return repository.findAll();
	}
	
	public Endereco buscar(Long id) {
		Optional<Endereco> cid = repository.findById(id);
		return cid.orElseThrow(()-> new ObjectNotFoundException(id));
	}
	
	public Endereco salvar(Endereco end) {
		return repository.save(end);
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
	
	public Endereco alterar (Long id, Endereco obj) {
		try {
			Endereco end = repository.getOne(id);
			update(end, obj);
			return repository.save(end);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	private void update(Endereco end, Endereco obj) {
		end.setLogradouro(obj.getLogradouro());
		end.setNumero(obj.getNumero());
		end.setBairro(obj.getBairro());
	}
	
	

}
