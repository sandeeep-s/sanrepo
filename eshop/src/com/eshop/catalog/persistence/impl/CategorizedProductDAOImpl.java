package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.CategorizedProduct;
import com.eshop.catalog.persistence.CategorizedProductDAO;

@Repository("categorizedProductDAO")
public class CategorizedProductDAOImpl extends GenericDAOImpl<CategorizedProduct, Long> implements CategorizedProductDAO {

	public CategorizedProductDAOImpl() {
		super(CategorizedProduct.class);
	}

}
