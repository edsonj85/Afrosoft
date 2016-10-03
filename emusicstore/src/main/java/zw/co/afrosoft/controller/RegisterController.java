package zw.co.afrosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zw.co.afrosoft.model.BillingAddress;
import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.ShippingAddress;
import zw.co.afrosoft.service.CustomerService;

@Controller
public class RegisterController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model){
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		
		return "registerCustomer";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerCustomerPost(@ModelAttribute(value="customer") Customer customer, BindingResult result, Model model){
		if(result.hasErrors()){
			return "registerCustomer";
		}
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}
}
