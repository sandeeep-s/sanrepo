package com.eshop.catalog.admin.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.admin.service.BrandService;
import com.eshop.catalog.model.Brand;

public class BrandConverter implements Converter<String, Brand> {

	@Inject
	@Named("brandService")
	private BrandService brandService;

	public BrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	@Override
	public Brand convert(String id) {
		return brandService.getBrandById(Long.valueOf(id));
	}

}
