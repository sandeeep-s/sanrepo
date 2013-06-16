package com.eshop.vehicle.form;

import java.io.Serializable;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleMakeForm implements Serializable {

	private Long id;

	private Integer version;

	private String name;

	private Media logoImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	//Name should be immutable. Hence private.
	public void setName(String name) {
		this.name = name;
	}

	@Valid
	public Media getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(Media logoImage) {
		this.logoImage = logoImage;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof VehicleMakeForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleMakeForm that = (VehicleMakeForm) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end VehicleMake