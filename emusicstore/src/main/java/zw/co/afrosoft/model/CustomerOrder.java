package zw.co.afrosoft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4865297206894450938L;
	@Id
	@GeneratedValue
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
	private ShippingAddress shippingAddress;
}
