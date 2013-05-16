package com.eshop.catalog.shop.service;

import java.util.List;

import com.eshop.catalog.model.Pattern;

public interface PatternShopService {

	public List<Pattern> getPatternsForBrand(Long brandId);
}
