package com.eshop.catalog.form;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.form.BaseForm;
import com.eshop.catalog.model.Category;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 29-Sep-2012 8:48:07 PM
 */
public class CategoryForm extends BaseForm {

	public String name;

	public String description;

	public Media image;

	public Category parentCategory;

	public CategoryForm() {

	}

	public CategoryForm(String name, String description, Media image, Category parentCategory) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.parentCategory = parentCategory;
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
	public Media getImage() {
		return image;
	}

	public void setImage(Media image) {
		this.image = image;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof CategoryForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final CategoryForm that = (CategoryForm) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}

}//end Category