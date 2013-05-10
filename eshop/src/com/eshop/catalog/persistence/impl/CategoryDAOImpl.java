package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.persistence.CategoryDAO;

@Repository("categoryDAO")
public class CategoryDAOImpl extends GenericDAOImpl<Category, Long> implements CategoryDAO {

	public CategoryDAOImpl() {
		super(Category.class);
	}

}
