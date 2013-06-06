package com.eshop.catalog.admin.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.admin.service.ProductService;
import com.eshop.catalog.model.Product;

public class ProductConverter implements Converter<String, Product> {

	@Inject
	@Named("productService")
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Product convert(String id) {
		if ("-1".equals(id)){
			return null;
		}
		return productService.getProductById(Long.valueOf(id));
	}

}
