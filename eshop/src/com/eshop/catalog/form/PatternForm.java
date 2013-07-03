package com.eshop.catalog.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.base.form.BaseForm;
import com.eshop.catalog.model.Brand;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @updated 10-Oct-2012 5:52:03 PM
 */
public class PatternForm extends BaseForm {

	private String name;

	private String description;

	private String warranty;

	private String importantNotes;

	private Brand brand;

	private List<Media> images;

	public PatternForm() {

	}

	public PatternForm(String name, Brand brand, String description, String warranty, String importantNotes, List<Media> images) {
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.warranty = warranty;
		this.importantNotes = importantNotes;
		this.images = images;
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

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getImportantNotes() {
		return importantNotes;
	}

	public void setImportantNotes(String importantNotes) {
		this.importantNotes = importantNotes;
	}

	@NotNull
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@NotEmpty
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PatternForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final PatternForm that = (PatternForm) other;
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

}//end PatternForm