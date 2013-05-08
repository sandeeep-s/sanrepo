package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 09-Oct-2012 12:11:08 PM
 */
@Embeddable
public class ProductPromotion implements Serializable{

	/**
	 * Optional back pointer
	 */
	@org.hibernate.annotations.Parent
	private Product product;

	@ManyToOne@JoinColumn(name = "promotion_id", nullable = false, updatable = false)
	private Promotion promotion;

	private ProductPromotion() {

	}

	public ProductPromotion(Product product, Promotion promotion) {
		this.product = product;
		this.promotion = promotion;
		
		product.getProductPromotions().add(this);
	}

	//Optional back pointer
	@org.hibernate.annotations.Parent
	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne
	@JoinColumn(name = "promotion_id", nullable = false, updatable = false)
	public Promotion getPromotion() {
		return promotion;
	}

	private void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public boolean equals(Object other) {
		if (!(other instanceof ProductPromotion)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final ProductPromotion that = (ProductPromotion) other;
		return this.product.equals(that.getProduct()) && this.promotion.equals(that.getPromotion());
	}

	public int hashCode() {
		return product.hashCode() + promotion.hashCode();
	}

}//end ProductPromotion