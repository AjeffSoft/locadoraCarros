package com.ajeff.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajeff.locadora.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
