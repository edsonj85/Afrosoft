package zw.co.afrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public String getProducts(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productList";
	}
}
