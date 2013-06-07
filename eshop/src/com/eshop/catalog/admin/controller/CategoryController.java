/**
 * 
 */
package com.eshop.catalog.admin.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.catalog.admin.service.CategoryService;
import com.eshop.catalog.model.Category;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listCategorys(Model model) {
		Set<Category> categorys = categoryService.getAllCategorys();
		model.addAttribute("categorys", categorys);
		return "categoryList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		return "addCategory";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditCategoryForm(@PathVariable Long id, Model model, HttpServletRequest request) {

		try {
			Category category = categoryService.getCategoryById(id);
			model.addAttribute("category", category);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Category with id " + id + " not found", e);
			model.addAttribute("categoryId", id);
			return "categoryNotFound";
		}

		return "editCategory";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addCategory(@Valid Category category, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addCategory";
		}

		category = categoryService.addCategory(category);
		model.addAttribute("category", category);
		return "addCategorySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getCategory(@PathVariable Long id, Model model) {

		try {
			Category category = categoryService.getCategoryById(id);
			model.addAttribute("category", category);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Category with id " + id + " not found", e);
			model.addAttribute("categoryId", id);
			return "categoryNotFound";
		}
		return "viewCategory";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateCategory(@Valid Category category, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editCategory";
		}

		category = categoryService.updateCategory(category);
		model.addAttribute("category", category);
		return "editCategorySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteCategory(@PathVariable Long id, Model model) {
		Category category = categoryService.deleteCategory(id);
		model.addAttribute("category", category);
		return "deleteCategorySuccess";
	}

}
