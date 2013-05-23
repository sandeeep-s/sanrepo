/**
 * 
 */
package com.eshop.vehiclefitment.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
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

	@ManyToOne
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
