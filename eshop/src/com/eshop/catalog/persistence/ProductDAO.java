package com.eshop.catalog.persistence;

import java.util.List;
import java.util.Map;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.catalog.model.Product;

public interface ProductDAO extends GenericDAO<Product, Long> {

	public List<Product> getProductsByDimension(Map<String, String> dimensionMap);
	
	public List<Product> getProductByTechSpec(Map<String, String> techSpecMap);

	public Product getProduct(Long productId);
	
}
