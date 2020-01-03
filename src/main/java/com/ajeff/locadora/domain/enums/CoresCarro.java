package com.ajeff.locadora.domain.enums;

public enum CoresCarro {

	BRANCO(1, "Branco"),
	PRETO(2, "Preto"),
	CINZA(3, "Cinza"),
	VERMELHO(4, "Vermelho");
	
	private Integer codigo;
	private String descricao;
	
	private CoresCarro(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static CoresCarro toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(CoresCarro x : CoresCarro.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}


	
	
	
	
}
