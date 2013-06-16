package com.eshop.vehicle.form;

import java.io.Serializable;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleTypeForm implements Serializable {

	private Long id;

	private Integer version;

	private String name;

	private Media image;

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

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Valid
	public Media getImage() {
		return image;
	}

	public void setImage(Media image) {
		this.image = image;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof VehicleTypeForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleTypeForm that = (VehicleTypeForm) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end VehicleTypeForm