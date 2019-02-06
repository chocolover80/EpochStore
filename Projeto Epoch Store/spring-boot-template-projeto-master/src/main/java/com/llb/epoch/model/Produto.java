package com.llb.epoch.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.websocket.OnError;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

@Entity
@Table (name = "tbproduto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank (message = "Nome é um campo obrigatório")
	private String nome;
	
	@NotNull (message = "Tipo é um campo obrigatório")
	@Enumerated (EnumType.STRING)
	private TipoProduto tipo;
	
	@Min(value = 1, message = "A quantidade mínima de um produto no estoque é 1")
	private int qtdeestoque;
	
	private String foto;
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	@Transient
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean temFoto() {
		if (!StringUtils.isEmpty(foto))
			return true;
		else
			return false;
	}

	@NotNull (message = "Valor é um campo obrigatório")
	@DecimalMin(value = "0.1", message = "O valor mínimo para um produto é de R$ 0,01")
	private double valor;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	
	public int getQtdeestoque() {
		return qtdeestoque;
	}
	public void setQtdeestoque(int qtdeestoque) {
		this.qtdeestoque = qtdeestoque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
