package com.ajeff.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajeff.locadora.domain.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long>{

}
