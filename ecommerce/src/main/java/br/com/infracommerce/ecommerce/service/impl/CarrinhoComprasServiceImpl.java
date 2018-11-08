package br.com.infracommerce.ecommerce.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infracommerce.ecommerce.models.CarrinhoCompras;
import br.com.infracommerce.ecommerce.models.ItemCompras;
import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.service.CarrinhoComprasService;

@Service
public class CarrinhoComprasServiceImpl implements CarrinhoComprasService {
	
	@Autowired
	private CarrinhoCompras carrinhoCompras;
	
	@Override
	public void addItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		if(carrinhoCompras.getItens().size()>0) {
			ItemCompras itemSelecao = carrinhoCompras.getItens().stream()
    				.filter(itemSel -> itemSel.getProduto().getCodigo().longValue()==produto.getCodigo().longValue())
    				.findAny()
    				.orElse(null);
			
			
			if(itemSelecao==null) {
				carrinhoCompras.getItens().add(new ItemCompras(produto, valorUnitario, quantidade));
			} else {
				itemSelecao.setQuantidade(itemSelecao.getQuantidade() + quantidade);
			}
			
		} else {
			carrinhoCompras.getItens().add(new ItemCompras(produto, valorUnitario, quantidade));
		}
	}
	
	@Override
	public void updItem(Produto produto, int quantidade) {
		if(carrinhoCompras.getItens().size()>0) {
			ItemCompras itemSelecao = carrinhoCompras.getItens().stream()
    				.filter(itemSel -> itemSel.getProduto().getCodigo().longValue()==produto.getCodigo().longValue())
    				.findAny()
    				.orElse(null);
			
			
			if(itemSelecao!=null) {
				itemSelecao.setQuantidade(itemSelecao.getQuantidade() + quantidade);
			}
		}
	}
	
	@Override
	public boolean removerItem(Produto produto) {
		return carrinhoCompras.getItens().removeIf(item -> produto.getCodigo().longValue()==item.getProduto().getCodigo().longValue());
	}
	
	@Override
	public boolean removerItem(int posicaoItem) {
	    	return carrinhoCompras.getItens().remove(posicaoItem);
	 }
	 
	@Override
	public BigDecimal getValorTotal() {
		 return BigDecimal.valueOf(carrinhoCompras.getItens().stream().mapToDouble(item -> item.getValorTotal().doubleValue()).sum());
	 }
	 
	@Override
	public ArrayList getTotais() {
		 ArrayList list = new ArrayList();
		 list.add(BigDecimal.valueOf(carrinhoCompras.getItens().stream().mapToDouble(item -> item.getValorTotal().doubleValue()).sum()));
		 list.add(carrinhoCompras.getItens().size());
		 return list;
		 
	 }

	@Override
	public Collection<ItemCompras> getItens() {
		return carrinhoCompras.getItens();
	}

	@Override
	public void setItens(Collection<ItemCompras> itens) {
		carrinhoCompras.setItens(itens);
	}
	 
	 
	 

}
