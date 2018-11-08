package br.com.infracommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.infracommerce.ecommerce.entity.ProdutoEntity;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Long>{
	List<ProdutoEntity> findAll();
}
