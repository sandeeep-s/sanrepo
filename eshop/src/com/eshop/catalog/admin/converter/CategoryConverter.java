package com.eshop.catalog.admin.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.admin.service.CategoryService;
import com.eshop.catalog.model.Category;

public class CategoryConverter implements Converter<String, Category> {

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
	public Category convert(String id) {
		return categoryService.getCategoryById(Long.valueOf(id));
	}

}
