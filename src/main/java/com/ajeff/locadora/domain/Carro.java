package com.ajeff.locadora.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ajeff.locadora.domain.enums.CoresCarro;

@Entity
public class Carro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private String placa;
	private Integer ano;
	private Date aquisicao;
	
	private Integer cor;
	
	public Carro () {}

	public Carro(Long id, String modelo, String placa, Integer ano, Date aquisicao, CoresCarro cor) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.aquisicao = aquisicao;
		this.cor = cor.getCodigo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Date getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(Date aquisicao) {
		this.aquisicao = aquisicao;
	}

	public CoresCarro getCor() {
		return CoresCarro.toEnum(cor);
	}

	public void setCor(CoresCarro cor) {
		this.cor = cor.getCodigo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
