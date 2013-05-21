package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.persistence.DimensionPropertyDAO;

@Repository("dimensionPropertyDAO")
public class DimensionPropertyDAOImpl extends GenericDAOImpl<DimensionProperty, Long> implements DimensionPropertyDAO {

	public DimensionPropertyDAOImpl() {
		super(DimensionProperty.class);
	}

}
