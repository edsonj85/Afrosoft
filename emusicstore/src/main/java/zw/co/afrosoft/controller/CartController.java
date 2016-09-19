package zw.co.afrosoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import zw.co.afrosoft.dao.CartDao;
import zw.co.afrosoft.dao.ProductDao;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;
import zw.co.afrosoft.model.Product;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId){
		return cartDao.read(cartId);
	}
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value="cartId") String cartId, @RequestBody Cart cart){
		cartDao.update(cartId, cart);
	}
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="cartId")String cartId){
		cartDao.delete(cartId);
	}
	
	@RequestMapping(value="/add/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="productId") Integer productId, HttpServletRequest request){
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if(cart == null){
			cart = new Cart(sessionId);
		}
		
		Product product = productDao.getProductById(productId);
		if(product==null){
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.addCartItem(new CartItem(product));
		cartDao.update(sessionId, cart);
	}
	
	public void deleteItem(@PathVariable(value="productId") Integer productId, HttpServletRequest request){
		String sessionId = request.getSession(true).getId();
		
	}
}
