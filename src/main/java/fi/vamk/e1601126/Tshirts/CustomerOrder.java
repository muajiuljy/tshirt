package fi.vamk.e1601126.Tshirts;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_order database table.
 * 
 */
@Entity
@Table(name="customer_order")
@NamedQuery(name="CustomerOrder.findAll", query="SELECT c FROM CustomerOrder c")
public class CustomerOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerOrderPK id;

	private String city;

	private String country;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderid", insertable = false, updatable = false)
	private Order order;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerid", insertable = false, updatable = false)
	private Customer customer;

	public CustomerOrder() {
	}

	public CustomerOrderPK getId() {
		return this.id;
	}

	public void setId(CustomerOrderPK id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}