package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.persistence.ProductSpecDAO;

@Repository("productSpecDAO")
public class ProductSpecDAOImpl extends GenericDAOImpl<ProductSpec, Long> implements ProductSpecDAO {

	public ProductSpecDAOImpl() {
		super(ProductSpec.class);
	}

}
