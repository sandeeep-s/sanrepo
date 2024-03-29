package com.etyre.catalog.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 29-Sep-2012 8:48:07 PM
 */
@Entity
public class Category implements Serializable {

	private Long id;

	private int version;

	private String name;

	private String description;

	private String image;

	private Category parentCategory;

	private Set<Category> children;

	private Set<Brand> brands;

	private Set<CategorizedProduct> categorizedProducts;

	public Category() {

	}

	/*Constructor with non-nullable field*/
	public Category(String name) {
		this.name = name;
	}

	public Category(String name, String description, String image, Category parentCategory) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.parentCategory = parentCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	private void setVersion(int version) {
		this.version = version;
	}

	@Column(nullable = false, unique = true, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 4000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(nullable = false, length = 250)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne
	@JoinColumn(name = "parentCategory_Id")
	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	@OneToMany(mappedBy = "parentCategory")
	public Set<Category> getChildren() {
		return children;
	}

	public void setChildren(Set<Category> children) {
		this.children = children;
	}

	/**
	 * Returning unmodifiabllist to avoid modification of only one side of bidirectional relationship
	 * @return
	 */
	@ManyToMany(mappedBy = "categories")
	public Set<Brand> getBrands() {
		return Collections.unmodifiableSet(brands);
	}

	private void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	@OneToMany(mappedBy = "category")
	public Set<CategorizedProduct> getCategorizedProducts() {
		return categorizedProducts;
	}

	public void setCategorizedProducts(Set<CategorizedProduct> categorizedProducts) {
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

	public int hashCode() {
		return name.hashCode();
	}

}//end Category