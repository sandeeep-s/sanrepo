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

import com.eshop.catalog.admin.service.PatternService;
import com.eshop.catalog.model.Pattern;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/pattern")
public class PatternController {

	@Inject
	@Named("patternService")
	private PatternService patternService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

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

	@RequestMapping(method = RequestMethod.GET)
	public String listPatterns(Model model) {
		Set<Pattern> patterns = patternService.getAllPatterns();
		model.addAttribute("patterns", patterns);
		return "patternList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddPatternForm(Model model) {
		model.addAttribute("pattern", new Pattern());
		return "addPattern";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditPatternForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		Pattern pattern = patternService.getPatternById(id);
		model.addAttribute("pattern", pattern);

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
		Pattern pattern = patternService.getPatternById(id);
		model.addAttribute("pattern", pattern);
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
	public String deletePattern(@PathVariable Long id) {
		patternService.deletePattern(id);
		return "deletePatternSuccess";
	}

}
