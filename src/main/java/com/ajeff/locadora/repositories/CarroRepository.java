package com.ajeff.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajeff.locadora.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
