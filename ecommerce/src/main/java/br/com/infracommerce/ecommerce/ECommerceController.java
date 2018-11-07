package br.com.infracommerce.ecommerce;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.infracommerce.ecommerce.models.CarrinhoCompras;
import br.com.infracommerce.ecommerce.models.ItemCompras;
import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.service.ProdutosService;

@Controller
public class ECommerceController {
	
	@Autowired
	private ProdutosService produtosService;
	
	@Autowired
	CarrinhoCompras carrinho;
	
	
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
	
	@RequestMapping(value = "/carrinho", method = RequestMethod.GET)
	@ResponseBody
	public String listaCarrinho(Model model, HttpSession session) {
		Collection<ItemCompras> itensCarrinho = carrinho.getItens();
		Gson gson = new Gson();
		String itens = gson.toJson(itensCarrinho);
		return itens;		
	}
	
	@RequestMapping(value = "/carrinho", method = RequestMethod.POST)
	@ResponseBody
	public String addicionaCarrinho(Model model, HttpSession session) {
		Collection<ItemCompras> itensCarrinho = carrinho.getItens();
		Gson gson = new Gson();
		String itens = gson.toJson(itensCarrinho);
		return itens;		
	}
	

}
