package zw.co.afrosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;
import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.CartItemService;
import zw.co.afrosoft.service.CartService;
import zw.co.afrosoft.service.CustomerService;
import zw.co.afrosoft.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping(value="/{cartId}")
	public @ResponseBody Cart getCart(@PathVariable(value="cartId") Integer cartId){
		Cart cart = cartService.getCartById(cartId);
		return cart;
	}
	
	@RequestMapping(value="/add/{productId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="productId") Integer productId, @AuthenticationPrincipal User user){
		Customer customer = customerService.getCustomerByUsername(user.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> items = cart.getCartItems();
		
		for(int i = 0; i< items.size(); i++){
			if(product.getProductId() == items.get(i).getProduct().getProductId()){
				CartItem cartItem = items.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(cartItem.getQuantity() * product.getProductPrice());
				cartItemService.addCartItem(cartItem);
				break;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
		cartItemService.addCartItem(cartItem);
	}
	
	@RequestMapping("/remove/{productId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable int productId){
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping("/clearCart/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable(value="cartId") Integer cartId){
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Illegal request, please verify your payload.")
	public void handleClientExceptions(Exception ex){}
	
	@ExceptionHandler(value={Exception.class})
	@ResponseStatus(reason="Internal Server Error", value=HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleServerException(Exception ex){}
}
