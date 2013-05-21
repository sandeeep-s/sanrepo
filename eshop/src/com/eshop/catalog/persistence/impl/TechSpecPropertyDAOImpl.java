package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.catalog.persistence.TechSpecPropertyDAO;

@Repository("techSpecPropertyDAO")
public class TechSpecPropertyDAOImpl extends GenericDAOImpl<TechSpecProperty, Long> implements TechSpecPropertyDAO {

	public TechSpecPropertyDAOImpl() {
		super(TechSpecProperty.class);
	}

}
