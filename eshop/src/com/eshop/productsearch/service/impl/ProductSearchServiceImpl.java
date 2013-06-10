package com.eshop.productsearch.service.impl;

import java.util.List;

import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.TechSpec;
import com.eshop.productsearch.service.ProductSearchService;

public class ProductSearchServiceImpl implements ProductSearchService{

	@Override
	public List<Product> searchProductsByCategoryAndBrand(Long categoryId, Long brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductsByCategoryAndBrandAndPattern(Long categoryId, Long brandId, Long patternId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductsByCategoryAndDimensions(Long categoryId, List<Dimension> dimensions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductsByCategoryAndTechSpecs(Long categoryId, List<TechSpec> techSpecs) {
		// TODO Auto-generated method stub
		return null;
	}

}
