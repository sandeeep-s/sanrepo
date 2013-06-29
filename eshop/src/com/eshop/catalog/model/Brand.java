package com.eshop.catalog.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.model.EntityBase;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 29-Sep-2012 8:48:07 PM
 */
@Entity
@Table(name = "brand")
public class Brand extends EntityBase {

	private String name;

	private String description;

	private Media logoImage;

	public Brand() {

	}

	public Brand(String name, String description, Media logoImage) {
		this.name = name;
		this.description = description;
		this.logoImage = logoImage;
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
	@Embedded
	public Media getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(Media logoImage) {
		this.logoImage = logoImage;
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
		if (!(other instanceof Brand)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Brand that = (Brand) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end Brands