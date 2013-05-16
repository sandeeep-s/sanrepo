package com.eshop.catalog.persistence.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.persistence.ProductDAO;

@Repository("productDAO")
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

	public ProductDAOImpl() {
		super(Product.class);
	}

	public List<Product> getProductsByDimension(Map<String, String> dimensionMap) {
		return null;
	}

	public List<Product> getProductByTechSpec(Map<String, String> techSpecMap) {
		return null;
	}

}
