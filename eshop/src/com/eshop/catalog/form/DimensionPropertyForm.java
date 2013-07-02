package com.eshop.catalog.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.form.BaseForm;
import com.eshop.catalog.model.Category;

public class DimensionPropertyForm extends BaseForm {

	public String name;

	public String unit;

	public String description;

	public Category category;

	public DimensionPropertyForm() {

	}

	public DimensionPropertyForm(String name, String unit, String description, Category category) {
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.category = category;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof DimensionPropertyForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final DimensionPropertyForm that = (DimensionPropertyForm) other;
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

}//end Dimensions