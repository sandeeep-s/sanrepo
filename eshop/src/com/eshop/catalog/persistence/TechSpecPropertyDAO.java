package com.eshop.catalog.persistence;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.model.TechSpecProperty;

public interface TechSpecPropertyDAO extends GenericDAO<TechSpecProperty, Long> {

	public TechSpecProperty getTechSpecPropertyInitialized(Long techSpecPropertyId);
	
}
