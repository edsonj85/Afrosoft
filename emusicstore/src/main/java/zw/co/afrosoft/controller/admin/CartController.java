package zw.co.afrosoft.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public String getCart(@AuthenticationPrincipal User user){
		Customer customer = customerService.getCustomerByUsername(user.getUsername());
		Integer cartId = customer.getCart().getCartId();
		return "redirect:/customer/cart/"+cartId;
	}
	
	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value="cartId") Integer cartId, Model model){
		model.addAttribute("s", cartId);
		
		return "cart";
	}
}
