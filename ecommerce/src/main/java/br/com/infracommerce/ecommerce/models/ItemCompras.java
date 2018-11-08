package br.com.infracommerce.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemCompras implements Serializable {
	
	
	private Produto produto;
	private int quantidade;
	private BigDecimal valorUnitario;
	
	public ItemCompras(Object item) {
		System.out.println(item.toString());
		
	}
	
	public ItemCompras(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
	}
	
	public ItemCompras() {
		
	}
	
	

}
