package com.eshop.catalog.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.persistence.BrandDAO;

@Repository("brandJPADAO")
public class BrandJPADAO extends GenericJPADAO<Brand, Long> implements BrandDAO {

	public BrandJPADAO() {
		super(Brand.class);
	}

	@Override
	public Brand update(Brand detachedInstance) {
		Brand persistentInstance = update(detachedInstance, false);
		return persistentInstance;
	}

	@Override
	public Brand update(Brand detachedInstance, Boolean flush) {
		Brand persistentInstance = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
		persistentInstance.setDescription(detachedInstance.getDescription());
		persistentInstance.setLogoImage(detachedInstance.getLogoImage());
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedInstance.getId() + " updated");
		}
		return persistentInstance;
	}

}
