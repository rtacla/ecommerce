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
	
	@RequestMapping("/")
	public String index() {
		return "carrinho.html";
	}

}
