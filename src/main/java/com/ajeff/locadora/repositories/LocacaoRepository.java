package com.ajeff.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajeff.locadora.domain.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

}
