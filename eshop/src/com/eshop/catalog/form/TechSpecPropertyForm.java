package com.eshop.catalog.form;

import com.eshop.base.form.BaseForm;
import com.eshop.catalog.model.Category;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 03-Oct-2012 9:57:15 PM
 */
public class TechSpecPropertyForm extends BaseForm {

	private String name;

	private String unit;

	private String description;

	private Category category;

	public TechSpecPropertyForm() {

	}

	public TechSpecPropertyForm(String name, String unit, String description, Category category) {
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof TechSpecPropertyForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final TechSpecPropertyForm that = (TechSpecPropertyForm) other;
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