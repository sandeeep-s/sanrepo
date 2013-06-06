/**
 * 
 */
package com.eshop.catalog.admin.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.eshop.catalog.admin.service.BrandService;
import com.eshop.catalog.admin.service.PatternService;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.model.Pattern;
import com.eshop.common.model.Media;
import com.eshop.common.model.MediaType;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/pattern")
public class PatternController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("patternService")
	private PatternService patternService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("brandService")
	private BrandService brandService;

	public PatternService getPatternService() {
		return patternService;
	}

	public void setPatternService(PatternService patternService) {
		this.patternService = patternService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	public BrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listPatterns(Model model) {
		Set<Pattern> patterns = patternService.getAllPatterns();
		model.addAttribute("patterns", patterns);
		return "patternList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddPatternForm(Model model) {
		Pattern pattern = new Pattern();
		List<Media> images = new ArrayList<Media>();
		images.add(new Media());
		pattern.setImages(images);
		model.addAttribute("pattern", pattern);

		Set<Brand> brands = brandService.getAllBrands();
		model.addAttribute("brands", brands);

		return "addPattern";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditPatternForm(@PathVariable Long id, Model model, HttpServletRequest request) {

		try {
			Pattern pattern = patternService.getPatternById(id);
			model.addAttribute("pattern", pattern);

			Set<Brand> brands = brandService.getAllBrands();
			model.addAttribute("brands", brands);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Pattern with id " + id + " not found", e);
			model.addAttribute("patternId", id);
			return "patternNotFound";
		}

		return "editPattern";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addPattern(@Valid Pattern pattern, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addPattern";
		}

		pattern = patternService.addPattern(pattern);
		model.addAttribute("pattern", pattern);
		return "addPatternSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getPattern(@PathVariable Long id, Model model) {

		try {
			Pattern pattern = patternService.getPatternById(id);
			model.addAttribute("pattern", pattern);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Pattern with id " + id + " not found", e);
			model.addAttribute("patternId", id);
			return "patternNotFound";
		}

		return "viewPattern";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updatePattern(@Valid Pattern pattern, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editPattern";
		}

		pattern = patternService.updatePattern(pattern);
		model.addAttribute("pattern", pattern);
		return "editPatternSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletePattern(@PathVariable Long id, Model model) {
		Pattern pattern = patternService.deletePattern(id);
		model.addAttribute("pattern", pattern);
		return "deletePatternSuccess";
	}

}
