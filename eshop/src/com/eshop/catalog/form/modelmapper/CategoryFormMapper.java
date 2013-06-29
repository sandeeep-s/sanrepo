package com.eshop.catalog.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.CategoryForm;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.service.CategoryService;

@Component("categoryFormMapper")
public class CategoryFormMapper implements FormModelMapper<CategoryForm, Category> {

	@Inject
	private CategoryService categoryService;

	@Override
	public CategoryForm mapModelToForm(Category model) {
		CategoryForm form = new CategoryForm(model.getName(), model.getDescription(), model.getImage(), model.getParentCategory(),
				model.getCategorizedProducts());
		return form;
	}

	@Override
	public Category mapFormToNewModel(CategoryForm form) {
		Category category = new Category(form.getName(), form.getDescription(), form.getImage(), form.getParentCategory(),
				form.getCategorizedProducts());
		return category;
	}

	@Override
	public Category mapFormToExistingModel(CategoryForm form) {
		Category category = categoryService.getCategoryById(form.getId());
		category.setVersion(form.getVersion());
		category.setCategorizedProducts(form.getCategorizedProducts());
		category.setDescription(form.getDescription());
		category.setParentCategory(form.getParentCategory());
		category.setImage(form.getImage());
		return category;
	}

}
