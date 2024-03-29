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
import com.eshop.catalog.form.BrandForm;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.service.BrandService;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("brandService")
	private BrandService brandService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("brandFormMapper")
	private FormModelMapper<BrandForm, Brand> formModelMapper;

	public BrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listBrands(Model model) {
		Set<Brand> brands = brandService.getAllBrands();
		model.addAttribute("brands", brands);
		return "brandList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddBrandForm(Model model) {
		model.addAttribute("brand", new BrandForm());
		return "addBrand";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditBrandForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		try {
			Brand brand = brandService.getBrandById(id);
			BrandForm brandForm = formModelMapper.mapModelToForm(brand);
			model.addAttribute("brand", brandForm);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Brand with id " + id + " not found", e);
			model.addAttribute("brandId", id);
			return "brandNotFound";
		}

		return "editBrand";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addBrand(@Valid BrandForm brandForm, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addBrand";
		}

		Brand brand = formModelMapper.mapFormToNewModel(brandForm);
		brand = brandService.addBrand(brand);
		model.addAttribute("brand", brand);
		return "addBrandSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getBrand(@PathVariable Long id, Model model) {
		try {
			Brand brand = brandService.getBrandById(id);
			model.addAttribute("brand", brand);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Brand with id " + id + " not found", e);
			model.addAttribute("brandId", id);
			return "brandNotFound";
		}
		return "viewBrand";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateBrand(@Valid BrandForm brandForm, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editBrand";
		}
		Brand brand = formModelMapper.mapFormToExistingModel(brandForm);
		brand = brandService.updateBrand(brand);
		model.addAttribute("brand", brand);
		return "editBrandSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteBrand(@PathVariable Long id, Model model) {
		Brand brand = brandService.deleteBrand(id);
		model.addAttribute("brand", brand);
		return "deleteBrandSuccess";
	}

}
