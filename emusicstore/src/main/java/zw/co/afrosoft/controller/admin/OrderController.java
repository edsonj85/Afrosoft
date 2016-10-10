package zw.co.afrosoft.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.CustomerOrder;
import zw.co.afrosoft.service.CartService;
import zw.co.afrosoft.service.CustomerOrderService;

@Controller
@RequestMapping("/customer/order")
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("/{cartId}")
	public String customerOrder(@PathVariable("cartId") int cartId, Model model){
		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart = cartService.getCartById(cartId);
		customerOrder.setCart(cart);
		
		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());
		
		customerOrderService.addCustomerOrder(customerOrder);
		
		model.addAttribute("order", customerOrder);
		
		return "redirect:/checkout?cartId="+cartId;
	}
}
