package br.com.infracommerce.ecommerce.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.infracommerce.ecommerce.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	List<Produto> findAll();
}
