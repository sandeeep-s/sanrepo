package com.eshop.catalog.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.model.EntityBase;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 29-Sep-2012 8:48:07 PM
 */
@Entity
@Table(name = "category")
public class Category extends EntityBase {

	private String name;

	private String description;

	private Media image;

	private Category parentCategory;

	private List<Category> children;

	private List<CategorizedProduct> categorizedProducts;

	public Category() {

	}

	public Category(String name, String description, Media image, Category parentCategory,
			List<CategorizedProduct> categorizedProducts) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.parentCategory = parentCategory;
		this.categorizedProducts = categorizedProducts;
	}

	@NotBlank
	@Column(nullable = false, unique = true, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@NotBlank
	@Column(nullable = false, length = 750)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Valid
	@NotNull
	@Embedded
	public Media getImage() {
		return image;
	}

	public void setImage(Media image) {
		this.image = image;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_id")
	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * OneToMany with mappedBy establishes a bidirectional association. Property at the other end of the association is specified by attribute mappedBy.
	 * It also means that other end of the association will be used for any changes to the association. 
	 * @return
	 */
	@OneToMany(mappedBy = "parentCategory")
	public List<Category> getChildren() {
		return children;
	}

	private void setChildren(List<Category> children) {
		this.children = children;
	}

	/**
	 * OneToMany with mappedBy establishes a bidirectional association. Property at the other end of the association is specified by attribute mappedBy.
	 * It also means that other end of the association will be used for any changes to the association. 
	 * @return
	 */
	@OneToMany(mappedBy = "category")
	public List<CategorizedProduct> getCategorizedProducts() {
		return categorizedProducts;
	}

	public void setCategorizedProducts(List<CategorizedProduct> categorizedProducts) {
		this.categorizedProducts = categorizedProducts;
	}

	public void addProduct(Product product) {
		new CategorizedProduct(this, product);
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
		if (!(other instanceof Category)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Category that = (Category) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}

}//end Category