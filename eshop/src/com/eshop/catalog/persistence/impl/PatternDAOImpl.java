package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.persistence.PatternDAO;

@Repository("patternDAO")
public class PatternDAOImpl extends GenericDAOImpl<Pattern, Long> implements PatternDAO {

	public PatternDAOImpl() {
		super(Pattern.class);
	}

}
