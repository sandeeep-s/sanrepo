package com.eshop.catalog.model;

import java.io.Serializable;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This is an entity class representing many to many association between Category
 * and Product. Representing many to many association as entity class makes it
 * possible to add additional columns to association Also it bidirectional
 * navigation becomes possible.
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:23 PM
 */
@Entity
@Table(name = "category_product")
public class CategorizedProduct implements Serializable{

	/**
	 * Id class represents the composite key of CategorizedProduct entity It is marked
	 * as embeddable as its lifecycle is dependent on owning entity class.
	 * @author ssd1kor
	 * @version 1.0
	 * @updated 17-Oct-2012 3:50:23 PM
	 */
	@Embeddable
	public static class Id implements Serializable {

		@Column(name="category_id")
		private Long categoryId;

		@Column(name="product_id")
		private Long productId;

		private Id() {

		}

		private Id(Long categoryId, Long productId) {
			this.categoryId = categoryId;
			this.productId = productId;
		}

		public boolean equals(Object other) {
			if (null == other || !(other instanceof Id)) {
				return false;
			}
			Id that = (Id) other;
			return this.categoryId.equals(that.categoryId) && this.productId.equals(that.productId);
		}

		public int hashCode() {
			return categoryId.hashCode() + productId.hashCode();
		}
	}

	@EmbeddedId
	private Id id = new Id();

	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	public CategorizedProduct() {

	}

	public CategorizedProduct(Category category, Product product) {
		this.category = category;
		this.product = product;

		this.id.categoryId = category.getId();
		this.id.productId = product.getId();

		this.category.getCategorizedProducts().add(this);
		this.product.getCategorizedProducts().add(this);
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.id.categoryId = category.getId();
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.id.productId = product.getId();
		this.product = product;
	}

}//end CategorizedProduct

