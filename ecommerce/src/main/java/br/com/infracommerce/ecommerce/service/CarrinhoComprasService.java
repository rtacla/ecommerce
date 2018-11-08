package br.com.infracommerce.ecommerce.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import br.com.infracommerce.ecommerce.models.ItemCompras;
import br.com.infracommerce.ecommerce.models.Produto;

public interface CarrinhoComprasService {
	public void addItem(Produto produto, BigDecimal valorUnitario, int quantidade);
	public void updItem(Produto produto, int quantidade);
	public boolean removerItem(Produto produto);
	public boolean removerItem(int posicaoItem);
	public BigDecimal getValorTotal();
	public ArrayList getTotais();
	public Collection<ItemCompras> getItens();
	public void setItens(Collection<ItemCompras> itens);

}