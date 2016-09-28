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
	private ShippingAddress shippingAddress;
}
