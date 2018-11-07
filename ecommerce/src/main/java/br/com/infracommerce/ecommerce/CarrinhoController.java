package br.com.infracommerce.ecommerce;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.infracommerce.ecommerce.models.CarrinhoCompras;
import br.com.infracommerce.ecommerce.models.ItemCompras;

@Controller
public class CarrinhoController {
	
	@Autowired
	CarrinhoCompras carrinho;
	
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
	public String addicionaItemCarrinho(Model model, HttpSession session, @RequestBody ItemCompras item) {
		Collection<ItemCompras> itensCarrinho = carrinho.getItens();
		Gson gson = new Gson();
		String itens = gson.toJson(itensCarrinho);
		return itens;		
	}
	

}
