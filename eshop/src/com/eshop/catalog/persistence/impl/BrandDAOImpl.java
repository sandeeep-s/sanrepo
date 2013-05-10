package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.persistence.BrandDAO;

@Repository("brandDAO")
public class BrandDAOImpl extends GenericDAOImpl<Brand, Long> implements BrandDAO {

	public BrandDAOImpl() {
		super(Brand.class);
	}

}
