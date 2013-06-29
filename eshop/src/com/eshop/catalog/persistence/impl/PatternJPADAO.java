package com.eshop.catalog.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.persistence.PatternDAO;

@Repository("patternJPADAO")
public class PatternJPADAO extends GenericJPADAO<Pattern, Long> implements PatternDAO {

	public PatternJPADAO() {
		super(Pattern.class);
	}

	@Override
	public List<Pattern> findPatternsForBrand(Long brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pattern update(Pattern detachedInstance) {
		Pattern persistentInstance = update(detachedInstance, false);
		return persistentInstance;
	}

	@Override
	public Pattern update(Pattern detachedInstance, Boolean flush) {
		Pattern persistentInstance = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
		persistentInstance.setDescription(detachedInstance.getDescription());
		persistentInstance.setImportantNotes(detachedInstance.getImportantNotes());
		persistentInstance.setWarranty(detachedInstance.getWarranty());
		persistentInstance.setImages(detachedInstance.getImages());
		
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedInstance.getId() + " updated");
		}
		return persistentInstance;
	}

	
}
