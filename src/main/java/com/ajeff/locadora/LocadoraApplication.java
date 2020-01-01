package com.ajeff.locadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ajeff.locadora.domain.Estado;
import com.ajeff.locadora.repositories.EstadoRepository;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null, "Ceará");
		estadoRepository.save(e1);
	}

}
