package br.com.infracommerce.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
		
	}
	

}
