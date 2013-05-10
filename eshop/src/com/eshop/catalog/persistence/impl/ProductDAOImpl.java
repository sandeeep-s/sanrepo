package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.persistence.ProductDAO;

@Repository("productDAO")
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

	public ProductDAOImpl() {
		super(Product.class);
	}

}
