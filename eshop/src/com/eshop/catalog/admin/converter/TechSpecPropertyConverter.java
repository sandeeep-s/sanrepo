package com.eshop.catalog.admin.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.admin.service.TechSpecPropertyService;
import com.eshop.catalog.model.TechSpecProperty;

public class TechSpecPropertyConverter implements Converter<String, TechSpecProperty> {

	@Inject
	@Named("techSpecPropertyService")
	private TechSpecPropertyService techSpecPropertyService;

	public TechSpecPropertyService getTechSpecPropertyService() {
		return techSpecPropertyService;
	}

	public void setTechSpecPropertyService(TechSpecPropertyService techSpecPropertyService) {
		this.techSpecPropertyService = techSpecPropertyService;
	}

	@Override
	public TechSpecProperty convert(String id) {
		if ("-1".equals(id)){
			return null;
		}
		return techSpecPropertyService.getTechSpecPropertyById(Long.valueOf(id));
	}

}
