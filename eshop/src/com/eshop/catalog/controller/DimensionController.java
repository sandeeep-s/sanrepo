/**
 * 
 */
package com.eshop.catalog.controller;

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

import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.service.DimensionService;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/dimension")
public class DimensionController {

	@Inject
	@Named("dimensionService")
	private DimensionService dimensionService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	public DimensionService getDimensionService() {
		return dimensionService;
	}

	public void setDimensionService(DimensionService dimensionService) {
		this.dimensionService = dimensionService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listDimensions(Model model) {
		Set<Dimension> dimensions = dimensionService.getAllDimensions();
		model.addAttribute("dimensions", dimensions);
		return "dimensionList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddDimensionForm(Model model) {
		model.addAttribute("dimension", new Dimension());
		return "addDimension";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditDimensionForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		Dimension dimension = dimensionService.getDimensionById(id);
		model.addAttribute("dimension", dimension);

		return "editDimension";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addDimension(@Valid Dimension dimension, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addDimension";
		}

		dimension = dimensionService.addDimension(dimension);
		model.addAttribute("dimension", dimension);
		return "addDimensionSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getDimension(@PathVariable Long id, Model model) {
		Dimension dimension = dimensionService.getDimensionById(id);
		model.addAttribute("dimension", dimension);
		return "viewDimension";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateDimension(@Valid Dimension dimension, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editDimension";
		}

		dimension = dimensionService.updateDimension(dimension);
		model.addAttribute("dimension", dimension);
		return "editDimensionSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDimension(@PathVariable Long id) {
		dimensionService.deleteDimension(id);
		return "deleteDimensionSuccess";
	}

}
