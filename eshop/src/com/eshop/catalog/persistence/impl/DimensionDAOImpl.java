package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.persistence.DimensionDAO;

@Repository("dimensionDAO")
public class DimensionDAOImpl extends GenericDAOImpl<Dimension, Long> implements DimensionDAO {

	public DimensionDAOImpl() {
		super(Dimension.class);
	}

}
