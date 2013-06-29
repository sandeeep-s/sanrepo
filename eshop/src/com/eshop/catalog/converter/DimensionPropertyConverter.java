package com.eshop.catalog.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.service.DimensionPropertyService;

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
		if ("-1".equals(id)){
			return null;
		}
		return dimensionPropertyService.getDimensionPropertyById(Long.valueOf(id));
	}

}
