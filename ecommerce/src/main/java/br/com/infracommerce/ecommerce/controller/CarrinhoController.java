package br.com.infracommerce.ecommerce.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.infracommerce.ecommerce.models.ItemCompras;
import br.com.infracommerce.ecommerce.models.Produto;
import br.com.infracommerce.ecommerce.service.CarrinhoComprasService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	CarrinhoComprasService carrinho;
	
	@GetMapping
	@ResponseBody
	public String listaCarrinho(Model model, HttpSession session) {
		Collection<ItemCompras> itensCarrinho = carrinho.getItens();
		Gson gson = new Gson();
		String itens = gson.toJson(itensCarrinho);
		return itens;		
	}
	
	@PostMapping
	@ResponseBody
	public String addicionaItemCarrinho(Model model, HttpSession session, @RequestBody ItemCompras item) {
		carrinho.addItem(item.getProduto(), item.getValorUnitario(), item.getQuantidade());
		
		return carrinho.getValorTotal().toString();
	}
	
	
	@DeleteMapping
	@ResponseBody
	public String excluirItemCarrinho(Model model, HttpSession session, @RequestBody Produto produto) {
		carrinho.removerItem(produto);
		return carrinho.getValorTotal().toString();
	}
	
	
	@PutMapping
	@ResponseBody
	public String atualizarItemCarrinho(Model model, HttpSession session, @RequestBody ItemCompras item) {
		carrinho.updItem(item.getProduto(), item.getQuantidade());
		return carrinho.getValorTotal().toString();
	}
	
	
	
	
	@GetMapping("/totais")
	@ResponseBody
	public String total() {
		return carrinho.getTotais().toString();
	}
	

}
