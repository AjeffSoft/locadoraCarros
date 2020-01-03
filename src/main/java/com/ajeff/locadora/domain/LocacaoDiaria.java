package com.ajeff.locadora.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class LocacaoDiaria extends Locacao {
	private static final long serialVersionUID = 1L;
	
	private Integer dias;
	
	public LocacaoDiaria() {
		super();
	}

	public LocacaoDiaria(Long id, Date instante, Date devolucao, Integer dias) {
		super(id, instante, devolucao);
		this.dias = dias;
		
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}
	
	

}
