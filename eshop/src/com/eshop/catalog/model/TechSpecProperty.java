package com.eshop.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.model.EntityBase;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 03-Oct-2012 9:57:15 PM
 */
@Entity
@Table(name = "tech_spec_property")
public class TechSpecProperty extends EntityBase {

	private String name;

	private String unit;

	private String description;

	private Category category;

	public TechSpecProperty() {

	}

	public TechSpecProperty(String name, String unit, String description, Category category) {
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.category = category;
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
	@Column(nullable = false, length = 50)
	public String getUnit() {
		return unit;
	}

	private void setUnit(String unit) {
		this.unit = unit;
	}

	@NotBlank
	@Column(nullable = false, length = 750)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	private void setCategory(Category category) {
		this.category = category;
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
		if (!(other instanceof TechSpecProperty)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final TechSpecProperty that = (TechSpecProperty) other;
		return this.name.equals(that.getName()) && this.category.equals(that.getCategory());
	}

	@Override
	public int hashCode() {
		return name.hashCode() + category.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}

}//end TechSpec