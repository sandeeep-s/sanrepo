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
import com.eshop.catalog.admin.service.TechSpecPropertyService;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/techspecproperty")
public class TechSpecPropertyController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("techSpecPropertyService")
	private TechSpecPropertyService techSpecPropertyService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;

	public TechSpecPropertyService getTechSpecPropertyService() {
		return techSpecPropertyService;
	}

	public void setTechSpecPropertyService(TechSpecPropertyService techSpecPropertyService) {
		this.techSpecPropertyService = techSpecPropertyService;
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
	public String listTechSpecPropertys(Model model) {
		Set<TechSpecProperty> techSpecPropertys = techSpecPropertyService.getAllTechSpecPropertys();
		model.addAttribute("techSpecPropertys", techSpecPropertys);
		return "techSpecPropertyList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddTechSpecPropertyForm(Model model) {
		model.addAttribute("techSpecProperty", new TechSpecProperty());

		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);

		return "addTechSpecProperty";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditTechSpecPropertyForm(@PathVariable Long id, Model model, HttpServletRequest request) {

		try {
			TechSpecProperty techSpecProperty = techSpecPropertyService.getTechSpecPropertyById(id);
			model.addAttribute("techSpecProperty", techSpecProperty);

			Set<Category> categories = categoryService.getAllCategorys();
			model.addAttribute("categories", categories);

		} catch (ObjectRetrievalFailureException e) {
			logger.error("TechSpecProperty with id " + id + " not found", e);
			model.addAttribute("techSpecPropertyId", id);
			return "techSpecPropertyNotFound";
		}

		return "editTechSpecProperty";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addTechSpecProperty(@Valid TechSpecProperty techSpecProperty, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addTechSpecProperty";
		}

		techSpecProperty = techSpecPropertyService.addTechSpecProperty(techSpecProperty);
		model.addAttribute("techSpecProperty", techSpecProperty);
		return "addTechSpecPropertySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getTechSpecProperty(@PathVariable Long id, Model model) {

		try {
			TechSpecProperty techSpecProperty = techSpecPropertyService.getTechSpecPropertyById(id);
			model.addAttribute("techSpecProperty", techSpecProperty);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("TechSpecProperty with id " + id + " not found", e);
			model.addAttribute("techSpecPropertyId", id);
			return "techSpecPropertyNotFound";
		}

		return "viewTechSpecProperty";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateTechSpecProperty(@Valid TechSpecProperty techSpecProperty, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editTechSpecProperty";
		}

		techSpecProperty = techSpecPropertyService.updateTechSpecProperty(techSpecProperty);
		model.addAttribute("techSpecProperty", techSpecProperty);
		return "editTechSpecPropertySuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteTechSpecProperty(@PathVariable Long id, Model model) {
		TechSpecProperty techSpecProperty = techSpecPropertyService.deleteTechSpecProperty(id);
		model.addAttribute("techSpecProperty", techSpecProperty);
		return "deleteTechSpecPropertySuccess";
	}

}
