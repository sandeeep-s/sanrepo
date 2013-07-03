package com.eshop.catalog.form;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.form.BaseForm;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 29-Sep-2012 8:48:07 PM
 */
public class BrandForm extends BaseForm {

	private String name;

	private String description;

	private Media logoImage;

	public BrandForm() {

	}

	public BrandForm(String name, String description, Media logoImage) {
		this.name = name;
		this.description = description;
		this.logoImage = logoImage;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Valid
	@NotNull
	public Media getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(Media logoImage) {
		this.logoImage = logoImage;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof BrandForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final BrandForm that = (BrandForm) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end Brands