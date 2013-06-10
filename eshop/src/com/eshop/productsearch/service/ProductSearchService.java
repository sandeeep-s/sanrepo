package com.eshop.productsearch.service;

import java.util.List;

import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.TechSpec;

public interface ProductSearchService {

	public List<Product> searchProductsByCategoryAndBrand(Long categoryId, Long brandId);

	public List<Product> searchProductsByCategoryAndBrandAndPattern(Long categoryId, Long brandId, Long patternId);

	public List<Product> searchProductsByCategoryAndDimensions(Long categoryId, List<Dimension> dimensions);

	public List<Product> searchProductsByCategoryAndTechSpecs(Long categoryId, List<TechSpec> techSpecs);
	

}
