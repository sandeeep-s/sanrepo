/**
 * 
 */
package com.eshop.vehiclefitment.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eshop.catalog.model.Product;

/**
 * @author ssd1kor
 *
 */
@Embeddable
public class FitmentComponent implements Serializable {

	private Product product;

	private VehiclePosition position;

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public VehiclePosition getPosition() {
		return position;
	}

	public void setPosition(VehiclePosition position) {
		this.position = position;
	}

	/**
	 * If this object is used as detached object, it can be outside guaranteed scope identity of persistence context.
	 * In this case there can be two different objects representing the same row in database. They will have same database identity 
	 * but different java identity. 
	 * Hence override equals and hashcode method as default check only java identity.
	 * 
	 * Use a business key comparison in the equals method. Business key characteristics are uniqueness, non-nullability and rare change.
	 * 
	 * Using id comparison in equals is strongly discouraged as id is assigned by Hibernate only after persistence. This can result in 
	 * changed hash value after object is added to a SET(Collection). This breaks SET contract.
	 * 
	 * Always use getters to compare properties of other object. This is to make sure the code works even if proxies are passed instead
	 * of real objects.
	 */
	public boolean equals(Object other) {
		if (!(other instanceof FitmentComponent)) {
			return false;
		}

		if (other == this) {
			return true;
		}

		final FitmentComponent that = (FitmentComponent) other;
		return this.position.equals(that.getPosition()) && this.product.equals(that.product);

	}

	public int hashCode() {
		return position.hashCode() + product.hashCode();
	}

	public String toString() {
		return ""+position + product;
	}
}
