package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.persistence.TechSpecDAO;

@Repository("techSpecDAO")
public class TechSpecDAOImpl extends GenericDAOImpl<TechSpec, Long> implements TechSpecDAO {

	public TechSpecDAOImpl() {
		super(TechSpec.class);
	}

}
