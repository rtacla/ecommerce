package br.com.infracommerce.ecommerce.models;

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

	public Collection<ItemCompras> getItens() {
		return itens;
	}

	public void setItens(Collection<ItemCompras> itens) {
		this.itens = itens;
	}
	
}
