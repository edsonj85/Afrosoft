package zw.co.afrosoft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@GenericGenerator(
        name = "tableGenerator",
        strategy = "org.hibernate.id.enhanced.TableGenerator"
)
public class CustomerOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4865297206894450938L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tableGenerator")
	private int customerOrderId;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@JoinColumn(name="shippingAddressId")
	@OneToOne
	@JsonIgnore
	private ShippingAddress shippingAddress;

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	
}
