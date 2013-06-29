package com.eshop.catalog.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.BrandForm;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.service.BrandService;

@Component("brandFormMapper")
public class BrandFormMapper implements FormModelMapper<BrandForm, Brand> {

	@Inject
	private BrandService brandService;

	@Override
	public BrandForm mapModelToForm(Brand model) {
		BrandForm form = new BrandForm(model.getName(), model.getDescription(), model.getLogoImage());
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		return form;
	}

	@Override
	public Brand mapFormToNewModel(BrandForm form) {
		Brand model = new Brand(form.getName(), form.getDescription(), form.getLogoImage());
		return model;
	}

	@Override
	public Brand mapFormToExistingModel(BrandForm form) {
		Brand model = brandService.getBrandById(form.getId());
		model.setVersion(form.getVersion());
		model.setDescription(form.getDescription());
		model.setLogoImage(form.getLogoImage());
		return model;
	}

}
