/**
 * 
 */
package com.eshop.catalog.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.catalog.persistence.TechSpecPropertyDAO;
import com.eshop.catalog.service.TechSpecPropertyService;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("techSpecPropertyService")
@Transactional(propagation = Propagation.REQUIRED)
public class TechSpecPropertyServiceImpl implements TechSpecPropertyService {

	private static final Logger logger = LoggerFactory.getLogger(TechSpecPropertyServiceImpl.class);

	@Inject
	private TechSpecPropertyDAO techSpecPropertyDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addTechSpecProperty(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public TechSpecProperty addTechSpecProperty(TechSpecProperty techSpecProperty) {
		return techSpecPropertyDAO.save(techSpecProperty);
	}

	@Override
	public TechSpecProperty getTechSpecPropertyById(Long techSpecPropertyId) {
		return techSpecPropertyDAO.getTechSpecPropertyInitialized(techSpecPropertyId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public TechSpecProperty updateTechSpecProperty(TechSpecProperty techSpecProperty) {
		return techSpecPropertyDAO.saveOrUpdate(techSpecProperty);
	}

	@Override
	public TechSpecProperty deleteTechSpecProperty(Long techSpecPropertyId) {
		TechSpecProperty techSpecProperty = techSpecPropertyDAO.getReference(techSpecPropertyId);
		techSpecPropertyDAO.delete(techSpecProperty);
		return techSpecProperty;
	}

	@Override
	public Set<TechSpecProperty> getAllTechSpecPropertys() {
		return techSpecPropertyDAO.findAllUnique();
	}

	@Override
	public TechSpecProperty createTechSpecProperty(String name, Media logoImage) {
		TechSpecProperty techSpecProperty = new TechSpecProperty();
		return techSpecProperty;
	}

}
