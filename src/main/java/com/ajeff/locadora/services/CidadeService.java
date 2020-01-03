package com.ajeff.locadora.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ajeff.locadora.domain.Cidade;
import com.ajeff.locadora.exceptions.DatabaseIntegrityException;
import com.ajeff.locadora.exceptions.ObjectNotFoundException;
import com.ajeff.locadora.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	
	public List<Cidade> lista(){
		return repository.findAll();
	}
	
	public Cidade buscar(Long id) {
		Optional<Cidade> cid = repository.findById(id);
		return cid.orElseThrow(()-> new ObjectNotFoundException(id));
	}
	
	public Cidade salvar(Cidade cid) {
		return repository.save(cid);
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
	
	public Cidade alterar (Long id, Cidade cid) {
		try {
			Cidade c = repository.getOne(id);
			update(c, cid);
			return repository.save(c);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	private void update(Cidade c, Cidade cid) {
		c.setNome(cid.getNome());
		c.setEstado(cid.getEstado());
	}
	
	

}
