package com.eshop.vehicle.form;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.base.form.BaseForm;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleTypeForm extends BaseForm {

	private String name;

	private Media image;

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