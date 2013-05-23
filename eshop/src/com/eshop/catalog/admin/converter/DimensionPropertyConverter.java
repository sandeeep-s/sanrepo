package com.eshop.catalog.admin.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.admin.service.DimensionPropertyService;
import com.eshop.catalog.model.DimensionProperty;

public class DimensionPropertyConverter implements Converter<String, DimensionProperty> {

	@Inject
	@Named("dimensionPropertyService")
	private DimensionPropertyService dimensionPropertyService;

	public DimensionPropertyService getDimensionPropertyService() {
		return dimensionPropertyService;
	}

	public void setDimensionPropertyService(DimensionPropertyService dimensionPropertyService) {
		this.dimensionPropertyService = dimensionPropertyService;
	}

	@Override
	public DimensionProperty convert(String id) {
		return dimensionPropertyService.getDimensionPropertyById(Long.valueOf(id));
	}

}
