package com.eshop.catalog.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import com.eshop.base.model.EntityBase;
import com.eshop.common.model.Media;

/**
 * Using the Joined inheritance strategy(Table per subclass) as polymorphic
 * associations and queries are required. Also Tire subclass has many additional
 * properties than the superclass product.
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:23 PM
 */
@Entity
@Table(name = "product")
public class Product extends EntityBase {

	private String name;

	private String description;

	private Brand brand;

	private ProductSpec productSpec;

	private List<CategorizedProduct> categorizedProducts;

	private List<Media> images;

	public Product() {

	}

	public Product(String name, String description, Brand brand, ProductSpec productSpec, List<CategorizedProduct> categorizedProducts,
			List<Media> images) {
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.productSpec = productSpec;
		this.categorizedProducts = categorizedProducts;
		this.images = images;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brand_id", nullable = false)
	public Brand getBrand() {
		return brand;
	}

	private void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(nullable = false, unique = true, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 750)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(mappedBy = "product", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	public ProductSpec getProductSpec() {
		return productSpec;
	}

	private void setProductSpec(ProductSpec productSpec) {
		this.productSpec = productSpec;
	}

	@OneToMany(mappedBy = "product", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	public List<CategorizedProduct> getCategorizedProducts() {
		return categorizedProducts;
	}

	public void setCategorizedProducts(List<CategorizedProduct> categorizedProducts) {
		this.categorizedProducts = categorizedProducts;
	}

	@ElementCollection
	@CollectionTable(name = "product_media", joinColumns = @JoinColumn(name = "product_id"))
	@OrderColumn(name = "sort_order")
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	public void addProductSpec(ProductSpec productSpec) {
		productSpec.setProduct(this);
		this.setProductSpec(productSpec);
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
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Product)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Product that = (Product) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end Product