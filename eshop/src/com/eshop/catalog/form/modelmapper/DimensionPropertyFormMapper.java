package com.eshop.catalog.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.DimensionPropertyForm;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.service.DimensionPropertyService;

@Component("dimensionPropertyFormMapper")
public class DimensionPropertyFormMapper implements FormModelMapper<DimensionPropertyForm, DimensionProperty> {

	@Inject
	private DimensionPropertyService dimensionPropertyService;

	@Override
	public DimensionPropertyForm mapModelToForm(DimensionProperty model) {
		DimensionPropertyForm form = new DimensionPropertyForm(model.getName(), model.getUnit(), model.getDescription(),
				model.getCategory());
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		return form;
	}

	@Override
	public DimensionProperty mapFormToNewModel(DimensionPropertyForm form) {
		DimensionProperty model = new DimensionProperty(form.getName(), form.getUnit(), form.getDescription(), form.getCategory());
		return model;
	}

	@Override
	public DimensionProperty mapFormToExistingModel(DimensionPropertyForm form) {
		DimensionProperty dimensionProperty = dimensionPropertyService.getDimensionPropertyById(form.getId());
		dimensionProperty.setVersion(form.getVersion());
		dimensionProperty.setDescription(form.getDescription());
		return dimensionProperty;
	}

}
