package fi.vamk.e1601126.Tshirts;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customer_order database table.
 * 
 */
@Embeddable
public class CustomerOrderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int customerid;

	@Column(insertable=false, updatable=false)
	private int orderid;

	public CustomerOrderPK() {
	}
	public int getCustomerid() {
		return this.customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getOrderid() {
		return this.orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerOrderPK)) {
			return false;
		}
		CustomerOrderPK castOther = (CustomerOrderPK)other;
		return 
			(this.customerid == castOther.customerid)
			&& (this.orderid == castOther.orderid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerid;
		hash = hash * prime + this.orderid;
		
		return hash;
	}
}