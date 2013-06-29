package com.eshop.catalog.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.TechSpecPropertyForm;
import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.catalog.service.TechSpecPropertyService;

@Component("techSpecPropertyFormMapper")
public class TechSpecPropertyFormMapper implements FormModelMapper<TechSpecPropertyForm, TechSpecProperty> {

	@Inject
	private TechSpecPropertyService techSpecPropertyService;

	@Override
	public TechSpecPropertyForm mapModelToForm(TechSpecProperty model) {
		TechSpecPropertyForm form = new TechSpecPropertyForm(model.getName(), model.getUnit(), model.getDescription(), model.getCategory());
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		return form;
	}

	@Override
	public TechSpecProperty mapFormToNewModel(TechSpecPropertyForm form) {
		TechSpecProperty model = new TechSpecProperty(form.getName(), form.getUnit(), form.getDescription(), form.getCategory());
		return model;
	}

	@Override
	public TechSpecProperty mapFormToExistingModel(TechSpecPropertyForm form) {
		TechSpecProperty techSpecProperty = techSpecPropertyService.getTechSpecPropertyById(form.getId());
		techSpecProperty.setVersion(form.getVersion());
		techSpecProperty.setDescription(form.getDescription());
		return techSpecProperty;
	}

}
