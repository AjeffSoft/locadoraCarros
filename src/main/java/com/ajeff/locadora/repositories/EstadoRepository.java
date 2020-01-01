package com.ajeff.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajeff.locadora.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
