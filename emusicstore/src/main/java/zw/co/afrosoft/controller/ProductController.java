package zw.co.afrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	public String getProducts(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping(value="/viewProduct/{productId}")
	public String viewProduct(@PathVariable Integer productId, Model model){
		Product product = productService.getProductById(productId);
		
		model.addAttribute("product", product);
		
		return "viewProduct";
	}
}