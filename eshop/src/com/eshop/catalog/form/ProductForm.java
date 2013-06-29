package com.eshop.catalog.form;

import java.util.List;

import com.eshop.base.form.BaseForm;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.model.CategorizedProduct;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:23 PM
 */
public class ProductForm extends BaseForm {

	private String name;

	private String description;

	private Brand brand;

	private ProductSpec productSpec;

	private List<CategorizedProduct> categorizedProducts;

	private List<Media> images;

	private ProductForm() {

	}

	public ProductForm(String name, String description, Brand brand, ProductSpec productSpec, List<CategorizedProduct> categorizedProducts,
			List<Media> images) {
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.productSpec = productSpec;
		this.categorizedProducts = categorizedProducts;
		this.images = images;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductSpec getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(ProductSpec productSpec) {
		this.productSpec = productSpec;
	}

	public List<CategorizedProduct> getCategorizedProducts() {
		return categorizedProducts;
	}

	public void setCategorizedProducts(List<CategorizedProduct> categorizedProducts) {
		this.categorizedProducts = categorizedProducts;
	}

	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ProductForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final ProductForm that = (ProductForm) other;
		return this.name.equals(that.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}//end ProductForm