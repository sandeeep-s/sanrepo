package com.eshop.catalog.persistence.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.persistence.DimensionPropertyDAO;

@Repository("dimensionPropertyJPADAO")
public class DimensionPropertyJPADAO extends GenericJPADAO<DimensionProperty, Long> implements DimensionPropertyDAO {

	public DimensionPropertyJPADAO() {
		super(DimensionProperty.class);
	}

	@Override
	public DimensionProperty getDimensionPropertyInitialized(Long dimensionPropertyId) {
		Query query = getEntityManager().createNamedQuery("getDimensionPropertyInitialized");
		query.setParameter("dimensionPropertyId", dimensionPropertyId);
		query.setMaxResults(1);
		DimensionProperty dimensionProperty = (DimensionProperty) query.getSingleResult();
		return dimensionProperty;
	}

	@Override
	public DimensionProperty getDimensionPropertyByName(String dimensionPropertyName) {
		Query query = getEntityManager().createNamedQuery("getDimensionPropertyByName");
		query.setParameter("dimensionPropertyName", dimensionPropertyName);
		query.setMaxResults(1);
		DimensionProperty dimensionProperty = (DimensionProperty) query.getSingleResult();
		return dimensionProperty;
	}

	@Override
	public DimensionProperty update(DimensionProperty detachedInstance) {
		DimensionProperty persistentInstance = update(detachedInstance, false);
		return persistentInstance;
	}

	@Override
	public DimensionProperty update(DimensionProperty detachedInstance, Boolean flush) {
		DimensionProperty persistentInstance = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
		persistentInstance.setDescription(detachedInstance.getDescription());
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedInstance.getId() + " updated");
		}
		return persistentInstance;
	}

}
