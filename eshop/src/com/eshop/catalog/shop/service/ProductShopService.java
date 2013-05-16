package com.eshop.catalog.shop.service;

import java.util.List;
import java.util.Map;

import com.eshop.catalog.model.Product;

public interface ProductShopService {
	
	public List<Product> getProductsByDimension(Map<String, String> dimensionMap);
	
	public List<Product> getProductByTechSpec(Map<String, String> techSpecMap);
	
}
