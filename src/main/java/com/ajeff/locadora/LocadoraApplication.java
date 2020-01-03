package com.ajeff.locadora;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ajeff.locadora.domain.Carro;
import com.ajeff.locadora.domain.Cidade;
import com.ajeff.locadora.domain.Cliente;
import com.ajeff.locadora.domain.Endereco;
import com.ajeff.locadora.domain.Estado;
import com.ajeff.locadora.domain.Locacao;
import com.ajeff.locadora.domain.LocacaoDiaria;
import com.ajeff.locadora.domain.Sede;
import com.ajeff.locadora.domain.enums.CoresCarro;
import com.ajeff.locadora.repositories.CarroRepository;
import com.ajeff.locadora.repositories.CidadeRepository;
import com.ajeff.locadora.repositories.ClienteRepository;
import com.ajeff.locadora.repositories.EnderecoRepository;
import com.ajeff.locadora.repositories.EstadoRepository;
import com.ajeff.locadora.repositories.LocacaoRepository;
import com.ajeff.locadora.repositories.SedeRepository;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private SedeRepository sedeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CarroRepository carroRepository;
	@Autowired
	private LocacaoRepository locacaoRepository;	
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null, "Ceará");
		Cidade cd1 = new Cidade(null, "Iguatu", e1);
		Cidade cd2 = new Cidade(null, "Fortaleza", e1);
		e1.getCidades().addAll(Arrays.asList(cd1, cd2));
		estadoRepository.save(e1);
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2));
		
		Endereco end1 = new Endereco(null, "Rua A", "22", "Centro", cd1);
		Endereco end2 = new Endereco(null, "Rua B", "3254", "Fatima", cd2);
		
		Sede s1 = new Sede(null, "-18.254125", "-22.23652", end1);
		Sede s2 = new Sede(null, "-25.36524", "-4.25415", end2);
		end1.setSede(s1);
		end2.setSede(s2);
		sedeRepository.saveAll(Arrays.asList(s1,s2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		Cliente cli1 = new Cliente(null, "Jefferson", "031664454", "jeff@gmail.com");
		cli1.getTelefones().addAll(Arrays.asList("032265646", "2656564"));
		clienteRepository.save(cli1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Carro c1 = new Carro(null, "Fox", "HGU2255", 2018, sdf.parse("30/12/2018"), CoresCarro.CINZA);
		Carro c2 = new Carro(null, "Gol", "XXT2566", 2012, sdf.parse("25/09/2012"), CoresCarro.VERMELHO);
		carroRepository.saveAll(Arrays.asList(c1,c2));
		
		Locacao loc1 = new LocacaoDiaria(null, sdf.parse("25/06/2019"), sdf.parse("30/06/2019"), 5);
		locacaoRepository.save(loc1);
	}

}
