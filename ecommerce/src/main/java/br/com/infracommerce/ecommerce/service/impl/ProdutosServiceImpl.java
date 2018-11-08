package br.com.infracommerce.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infracommerce.ecommerce.entity.ProdutoEntity;
import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.repository.ProdutoRepository;
import br.com.infracommerce.ecommerce.service.ProdutosService;

@Service
public class ProdutosServiceImpl implements ProdutosService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		try {
			List<ProdutoEntity> listProdutosEntity = produtoRepository.findAll();
			List<Produto> listProdutos = new ArrayList<Produto>();
			for(ProdutoEntity produtoEntity : listProdutosEntity) {
				Produto produto = new Produto();
				BeanUtils.copyProperties(produto, produtoEntity);
				listProdutos.add(produto);
			}
			return listProdutos;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

}
