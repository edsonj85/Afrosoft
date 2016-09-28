package zw.co.afrosoft.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@GenericGenerator(
        name = "tableGenerator",
        strategy = "org.hibernate.id.enhanced.TableGenerator"
)
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7562733597957917816L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tableGenerator")
	private int cartId;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CartItem> cartItems;
	
	@OneToOne()
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customer customer;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
