package com.eshop.catalog.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.model.CategorizedProduct;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.service.CategoryService;

public class CategorizedProductConverter implements Converter<String, CategorizedProduct>{

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public CategorizedProduct convert(String id) {
		if ("-1".equals(id)){
			return null;
		}
		
		Category category = categoryService.getCategoryById(Long.valueOf(id));
		CategorizedProduct categorizedProduct = new CategorizedProduct();
		categorizedProduct.setCategory(category);
		return categorizedProduct;
	}

}
