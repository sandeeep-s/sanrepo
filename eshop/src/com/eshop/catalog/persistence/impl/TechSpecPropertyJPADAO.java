package com.eshop.catalog.persistence.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.catalog.persistence.TechSpecPropertyDAO;

@Repository("techSpecPropertyJPADAO")
public class TechSpecPropertyJPADAO extends GenericJPADAO<TechSpecProperty, Long> implements TechSpecPropertyDAO {

	public TechSpecPropertyJPADAO() {
		super(TechSpecProperty.class);
	}

	@Override
	public TechSpecProperty getTechSpecPropertyInitialized(Long techSpecPropertyId) {
		Query query =  getEntityManager().createNamedQuery("getTechSpecPropertyInitialized");
		query.setParameter("techSpecPropertyId", techSpecPropertyId);
		query.setMaxResults(1);
		TechSpecProperty techSpecProperty = (TechSpecProperty)query.getSingleResult();
		return techSpecProperty;
	}

	@Override
	public TechSpecProperty update(TechSpecProperty detachedInstance) {
		TechSpecProperty persistentInstance = update(detachedInstance, false);
		return persistentInstance;
	}

	@Override
	public TechSpecProperty update(TechSpecProperty detachedInstance, Boolean flush) {
		TechSpecProperty persistentInstance = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
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
