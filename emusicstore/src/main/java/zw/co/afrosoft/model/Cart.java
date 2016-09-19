package zw.co.afrosoft.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String cartId;
	private Map<Long, CartItem> cartItems;
	private double grandTotal;
	
	public Cart(){
		this.cartItems = new HashMap<>();
		grandTotal = 0;
	}
	
	public Cart(String cartId){
		this();
		this.cartId = cartId;
	}
	
	public void addCartItem(CartItem cartItem){
		Long productId = (long)cartItem.getProduct().getProductId();
		
		if(cartItems.containsKey(productId)){
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity()+ cartItem.getQuantity());
			cartItems.put(productId, existingCartItem);
		}else{
			cartItems.put(productId, cartItem);
		}
		
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem cartItem){
		Long productId = (long)cartItem.getProduct().getProductId();
		cartItems.remove(productId);
		
		updateGrandTotal();
	}
	
	public void updateGrandTotal(){
		grandTotal = 0;
		for(CartItem item : cartItems.values()){
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	
	
}
