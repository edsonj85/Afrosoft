package zw.co.afrosoft.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.CustomerService;
import zw.co.afrosoft.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping("/customers")
	public String customerManagement(Model model){		
		List<Customer> customers = customerService.getAllCustomers();		
		model.addAttribute("customers", customers);
		
		return "customers";
	}
}
