package br.com.infracommerce.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.service.ProdutosService;

@Controller
public class ECommerceController {
	
	@Autowired
	private ProdutosService produtosService;
	
	
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/produtosDisponiveis")
	public String produtosDisponveis(Model model) {
		Iterable<Produto> produtos = produtosService.findAll();
		model.addAttribute("produtosDisponiveis", produtos);
		return "ProdutosDisponiveis";
		
		
	}

}
