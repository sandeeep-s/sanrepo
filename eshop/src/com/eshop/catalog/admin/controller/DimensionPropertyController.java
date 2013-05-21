/**
 * 
 */
package com.eshop.catalog.admin.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.catalog.admin.service.CategoryService;
import com.eshop.catalog.admin.service.DimensionPropertyService;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/dimensionproperty")
public class DimensionPropertyController {

	@Inject
	@Named("dimensionPropertyService")
	private DimensionPropertyService dimensionPropertyService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;

	public DimensionPropertyService getDimensionPropertyService() {
		return dimensionPropertyService;
	}

	public void setDimensionPropertyService(DimensionPropertyService dimensionPropertyService) {
		this.dimensionPropertyService = dimensionPropertyService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listDimensionPropertys(Model model) {
		Set<DimensionProperty> dimensionPropertys = dimensionPropertyService.getAllDimensionPropertys();
		model.addAttribute("dimensionPropertys", dimensionPropertys);
		return "dimensionPropertyList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddDimensionPropertyForm(Model model) {
		model.addAttribute("dimensionProperty", new DimensionProperty());
		
		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);

		return "addDimensionProperty";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditDimensionPropertyForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		DimensionProperty dimensionProperty = dimensionPropertyService.getDimensionPropertyById(id);
		model.addAttribute("dimensionProperty", dimensionProperty);

		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);

		return "editDimensionProperty";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addDimensionProperty(@Valid DimensionProperty dimensionProperty, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addDimensionProperty";
		}

		dimensionProperty = dimensionPropertyService.addDimensionProperty(dimensionProperty);
		model.addAttribute("dimensionProperty", dimensionProperty);
		return "addDimensionPropertySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getDimensionProperty(@PathVariable Long id, Model model) {
		DimensionProperty dimensionProperty = dimensionPropertyService.getDimensionPropertyById(id);
		model.addAttribute("dimensionProperty", dimensionProperty);
		return "viewDimensionProperty";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateDimensionProperty(@Valid DimensionProperty dimensionProperty, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editDimensionProperty";
		}

		dimensionProperty = dimensionPropertyService.updateDimensionProperty(dimensionProperty);
		model.addAttribute("dimensionProperty", dimensionProperty);
		return "editDimensionPropertySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDimensionProperty(@PathVariable Long id) {
		dimensionPropertyService.deleteDimensionProperty(id);
		return "deleteDimensionPropertySuccess";
	}

}
