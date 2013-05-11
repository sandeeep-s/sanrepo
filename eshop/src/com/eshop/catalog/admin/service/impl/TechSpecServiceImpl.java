/**
 * 
 */
package com.eshop.catalog.admin.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.admin.service.TechSpecService;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.persistence.TechSpecDAO;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("techSpecService")
@Transactional(propagation = Propagation.REQUIRED)
public class TechSpecServiceImpl implements TechSpecService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TechSpecServiceImpl.class);

	@Inject
	private TechSpecDAO techSpecDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addTechSpec(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public TechSpec addTechSpec(TechSpec techSpec) {
		return techSpecDAO.makePersistent(techSpec);
	}

	@Override
	public TechSpec getTechSpecById(Long techSpecId) {
		return techSpecDAO.findById(techSpecId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public TechSpec updateTechSpec(TechSpec techSpec) {
		return techSpecDAO.saveOrUpdate(techSpec);
	}

	@Override
	public void deleteTechSpec(Long techSpecId) {
		TechSpec techSpec = techSpecDAO.getReference(techSpecId);
		techSpecDAO.delete(techSpec);
	}

	@Override
	public Set<TechSpec> getAllTechSpecs() {
		return techSpecDAO.findAllUnique();
	}

	@Override
	public TechSpec createTechSpec(String name, Media logoImage) {
		TechSpec techSpec = new TechSpec();
		return techSpec;
	}

}
