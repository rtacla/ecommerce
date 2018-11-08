package br.com.infracommerce.ecommerce.service;

import java.util.List;

import br.com.infracommerce.ecommerce.models.Produto;

public interface ProdutosService {
	public List<Produto> findAll();
}
