package com.eshop.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import com.eshop.base.model.EntityBase;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(name = "vehicle_make")
public class VehicleMake extends EntityBase {

	private String name;

	private Media logoImage;

	public VehicleMake() {

	}

	public VehicleMake(String aName, Media aLogoImage) {
		this.name = aName;
		this.logoImage = aLogoImage;
	}

	@NotBlank
	@Column(unique = true, length = 250, nullable = false)
	public String getName() {
		return name;
	}

	//Name should be immutable. Hence private.
	private void setName(String name) {
		this.name = name;
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
	 * Hence override equals and hashcode method as default checks only java identity.
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
		if (!(other instanceof VehicleMake)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleMake that = (VehicleMake) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end VehicleMake