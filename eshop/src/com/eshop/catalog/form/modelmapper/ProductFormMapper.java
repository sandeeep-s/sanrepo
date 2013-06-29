package com.eshop.catalog.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.ProductForm;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.service.ProductService;

@Component("productFormMapper")
public class ProductFormMapper implements FormModelMapper<ProductForm, Product> {

	@Inject
	private ProductService productService;

	@Override
	public ProductForm mapModelToForm(Product model) {
		ProductForm form = new ProductForm(model.getName(), model.getDescription(), model.getBrand(), model.getProductSpec(),
				model.getCategorizedProducts(), model.getImages());
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		return form;
	}

	@Override
	public Product mapFormToNewModel(ProductForm form) {
		Product model = new Product(form.getName(), form.getDescription(), form.getBrand(), form.getProductSpec(),
				form.getCategorizedProducts(), form.getImages());
		return model;
	}

	@Override
	public Product mapFormToExistingModel(ProductForm form) {
		Product model = productService.getProductById(form.getId());
		model.setVersion(form.getVersion());
		model.setDescription(form.getDescription());
		model.setImages(form.getImages());
		model.setCategorizedProducts(model.getCategorizedProducts());
		return model;
	}

}
