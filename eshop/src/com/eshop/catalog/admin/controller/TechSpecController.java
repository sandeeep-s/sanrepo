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
import com.eshop.catalog.admin.service.TechSpecService;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.model.TechSpec;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/techspec")
public class TechSpecController {

	@Inject
	@Named("techSpecService")
	private TechSpecService techSpecService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;

	public TechSpecService getTechSpecService() {
		return techSpecService;
	}

	public void setTechSpecService(TechSpecService techSpecService) {
		this.techSpecService = techSpecService;
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
	public String listTechSpecs(Model model) {
		Set<TechSpec> techSpecs = techSpecService.getAllTechSpecs();
		model.addAttribute("techSpecs", techSpecs);
		return "techSpecList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddTechSpecForm(Model model) {
		model.addAttribute("techSpec", new TechSpec());

		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		
		return "addTechSpec";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditTechSpecForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		TechSpec techSpec = techSpecService.getTechSpecById(id);
		model.addAttribute("techSpec", techSpec);

		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);

		return "editTechSpec";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addTechSpec(@Valid TechSpec techSpec, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addTechSpec";
		}

		techSpec = techSpecService.addTechSpec(techSpec);
		model.addAttribute("techSpec", techSpec);
		return "addTechSpecSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getTechSpec(@PathVariable Long id, Model model) {
		TechSpec techSpec = techSpecService.getTechSpecById(id);
		model.addAttribute("techSpec", techSpec);
		return "viewTechSpec";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateTechSpec(@Valid TechSpec techSpec, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editTechSpec";
		}

		techSpec = techSpecService.updateTechSpec(techSpec);
		model.addAttribute("techSpec", techSpec);
		return "editTechSpecSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteTechSpec(@PathVariable Long id) {
		techSpecService.deleteTechSpec(id);
		return "deleteTechSpecSuccess";
	}

}
