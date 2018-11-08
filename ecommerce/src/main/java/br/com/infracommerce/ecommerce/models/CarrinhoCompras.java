package br.com.infracommerce.ecommerce.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, 
				proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras {
	
	private Collection<ItemCompras> itens = new ArrayList<ItemCompras>();

	
	public void addItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		if(itens.size()>0) {
			ItemCompras itemSelecao = itens.stream()
    				.filter(itemSel -> itemSel.getProduto().getCodigo().longValue()==produto.getCodigo().longValue())
    				.findAny()
    				.orElse(null);
			
			
			if(itemSelecao==null) {
				itens.add(new ItemCompras(produto, valorUnitario, quantidade));
			} else {
				itemSelecao.setQuantidade(itemSelecao.getQuantidade() + quantidade);
			}
			
		} else {
			itens.add(new ItemCompras(produto, valorUnitario, quantidade));
		}
	}
	
	public boolean removerItem(Produto produto) {
		return itens.removeIf(item -> produto.getCodigo().longValue()==item.getProduto().getCodigo().longValue());
	}
	
	 public boolean removerItem(int posicaoItem) {
	    	return itens.remove(posicaoItem);
	 }
	 
	 public BigDecimal getValorTotal() {
		 return BigDecimal.valueOf(itens.stream().mapToDouble(item -> item.getValorTotal().doubleValue()).sum());
	 }
	 
	 public ArrayList getTotais() {
		 ArrayList list = new ArrayList();
		 list.add(BigDecimal.valueOf(itens.stream().mapToDouble(item -> item.getValorTotal().doubleValue()).sum()));
		 list.add(itens.size());
		 return list;
		 
	 }

	public Collection<ItemCompras> getItens() {
		return itens;
	}

	public void setItens(Collection<ItemCompras> itens) {
		this.itens = itens;
	}
	 
	 
	 

}
