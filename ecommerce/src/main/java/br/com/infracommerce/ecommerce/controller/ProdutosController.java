package br.com.infracommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.service.ProdutosService;

@RequestMapping("/produtos")
@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutosService produtosService;
	
	
	@GetMapping
	@ResponseBody	
	public String produtosDisponveis(Model model) {
		Iterable<Produto> produtos = produtosService.findAll();
		Gson gson = new Gson();
		String produtosJson = gson.toJson(produtos);
		return produtosJson;		
	}

}
