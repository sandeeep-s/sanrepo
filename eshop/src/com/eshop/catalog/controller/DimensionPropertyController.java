/**
 * 
 */
package com.eshop.catalog.controller;

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

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.DimensionPropertyForm;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.service.CategoryService;
import com.eshop.catalog.service.DimensionPropertyService;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/dimensionproperty")
public class DimensionPropertyController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("dimensionPropertyService")
	private DimensionPropertyService dimensionPropertyService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;

	@Inject
	@Named("dimensionPropertyFormMapper")
	private FormModelMapper<DimensionPropertyForm, DimensionProperty> formModelMapper;

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
		model.addAttribute("dimensionProperty", new DimensionPropertyForm());

		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);

		return "addDimensionProperty";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditDimensionPropertyForm(@PathVariable Long id, Model model, HttpServletRequest request) {

		try {
			DimensionProperty dimensionProperty = dimensionPropertyService.getDimensionPropertyById(id);
			DimensionPropertyForm dimensionPropertyForm = formModelMapper.mapModelToForm(dimensionProperty);
			model.addAttribute("dimensionProperty", dimensionPropertyForm);

			Set<Category> categories = categoryService.getAllCategorys();
			model.addAttribute("categories", categories);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("DimensionProperty with id " + id + " not found", e);
			model.addAttribute("dimensionPropertyId", id);
			return "dimensionPropertyNotFound";
		}

		return "editDimensionProperty";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addDimensionProperty(@Valid DimensionPropertyForm dimensionPropertyForm, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addDimensionProperty";
		}

		DimensionProperty dimensionProperty = formModelMapper.mapFormToNewModel(dimensionPropertyForm);
		dimensionProperty = dimensionPropertyService.addDimensionProperty(dimensionProperty);
		model.addAttribute("dimensionProperty", dimensionProperty);
		return "addDimensionPropertySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getDimensionProperty(@PathVariable Long id, Model model) {
		try {
			DimensionProperty dimensionProperty = dimensionPropertyService.getDimensionPropertyById(id);
			model.addAttribute("dimensionProperty", dimensionProperty);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("DimensionProperty with id " + id + " not found", e);
			model.addAttribute("dimensionPropertyId", id);
			return "dimensionPropertyNotFound";
		}
		return "viewDimensionProperty";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateDimensionProperty(@Valid DimensionPropertyForm dimensionPropertyForm, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editDimensionProperty";
		}

		DimensionProperty dimensionProperty = formModelMapper.mapFormToExistingModel(dimensionPropertyForm);
		dimensionProperty = dimensionPropertyService.updateDimensionProperty(dimensionProperty);
		model.addAttribute("dimensionProperty", dimensionProperty);
		return "editDimensionPropertySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDimensionProperty(@PathVariable Long id, Model model) {
		DimensionProperty dimensionProperty = dimensionPropertyService.deleteDimensionProperty(id);
		model.addAttribute("dimensionProperty", dimensionProperty);
		return "deleteDimensionPropertySuccess";
	}

}
