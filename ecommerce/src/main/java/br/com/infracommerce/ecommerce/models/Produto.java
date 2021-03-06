package br.com.infracommerce.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {
	
	private Long codigo;
	private String descricao;
	private BigDecimal valor;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Produto(String codigo, String descricao, BigDecimal valor) {
		this.codigo = Long.valueOf(codigo);
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Produto() {
	}
	
	
	
	

}
