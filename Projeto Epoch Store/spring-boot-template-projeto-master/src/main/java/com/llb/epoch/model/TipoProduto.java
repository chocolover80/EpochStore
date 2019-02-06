package com.llb.epoch.model;

public enum TipoProduto {
	BOARDGAME ("Board-Game"),
	JOGOELETRONICO( "Jogo Eletrônico"),
	MANGA ("Mangá"),
	HQ ("HQ"),
	ELETRONICO ("Eletrônico"),
	COLECIONAVEL ("Colecionável");
	
	private String descricao;
	
	TipoProduto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
