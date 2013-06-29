package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.persistence.CategoryDAO;

@Repository("categoryJPADAO")
public class CategoryJPADAO extends GenericJPADAO<Category, Long> implements CategoryDAO {

	public CategoryJPADAO() {
		super(Category.class);
	}

	@Override
	public Category update(Category detachedInstance) {
		Category persistentInstance = update(detachedInstance, false);
		return persistentInstance;
	}

	@Override
	public Category update(Category detachedInstance, Boolean flush) {
		Category persistentInstance = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
		persistentInstance.setDescription(detachedInstance.getDescription());
		persistentInstance.setImage(detachedInstance.getImage());
		persistentInstance.setParentCategory(detachedInstance.getParentCategory());
		persistentInstance.setCategorizedProducts(detachedInstance.getCategorizedProducts());

		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedInstance.getId() + " updated");
		}
		return persistentInstance;
	}

}
