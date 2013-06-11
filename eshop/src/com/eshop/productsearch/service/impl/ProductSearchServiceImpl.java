package com.eshop.productsearch.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.persistence.ProductDAO;
import com.eshop.productsearch.service.ProductSearchService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ProductSearchServiceImpl implements ProductSearchService{

	@Inject
	private ProductDAO productDAO;
	
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
		
		return productDAO.findProductsByDimension(dimensions);
	}

	@Override
	public List<Product> searchProductsByCategoryAndTechSpecs(Long categoryId, List<TechSpec> techSpecs) {
		// TODO Auto-generated method stub
		return null;
	}

}
