package com.eshop.vehicle.form;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.base.form.BaseForm;
import com.eshop.common.form.MediaForm;
import com.eshop.common.model.Media;
import com.sun.istack.internal.NotNull;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleMakeForm extends BaseForm {

	private String name;

	private MediaForm logoImage;

	@NotBlank(message = "{name.cannot.be.blank}")
	public String getName() {
		return name;
	}

	//Name should be immutable. Hence private.
	public void setName(String name) {
		this.name = name;
	}

	@Valid
	public MediaForm getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(MediaForm logoImage) {
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