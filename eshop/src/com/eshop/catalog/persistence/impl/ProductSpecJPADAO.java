package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.persistence.ProductSpecDAO;

@Repository("productSpecJPADAO")
public class ProductSpecJPADAO extends GenericJPADAO<ProductSpec, Long> implements ProductSpecDAO {

	public ProductSpecJPADAO() {
		super(ProductSpec.class);
	}

	@Override
	public ProductSpec update(ProductSpec detachedInstance) {
		ProductSpec persistentInstance = update(detachedInstance, false);
		return persistentInstance;
	}

	@Override
	public ProductSpec update(ProductSpec detachedInstance, Boolean flush) {
		ProductSpec persistentInstance = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
		persistentInstance.setDimensions(detachedInstance.getDimensions());
		persistentInstance.setTechSpecs(detachedInstance.getTechSpecs());

		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedInstance.getId() + " updated");
		}
		return persistentInstance;
	}

}
