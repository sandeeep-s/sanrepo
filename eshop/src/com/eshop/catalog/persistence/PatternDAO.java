package com.eshop.catalog.persistence;

import java.util.List;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.model.Pattern;

public interface PatternDAO extends GenericDAO<Pattern, Long> {

	public List<Pattern> findPatternsForBrand(Long brandId);
	
}
