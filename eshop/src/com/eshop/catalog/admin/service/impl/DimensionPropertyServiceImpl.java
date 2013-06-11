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

import com.eshop.catalog.admin.service.DimensionPropertyService;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.persistence.DimensionPropertyDAO;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("dimensionPropertyService")
@Transactional(propagation = Propagation.REQUIRED)
public class DimensionPropertyServiceImpl implements DimensionPropertyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DimensionPropertyServiceImpl.class);

	@Inject
	private DimensionPropertyDAO dimensionPropertyDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addDimensionProperty(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public DimensionProperty addDimensionProperty(DimensionProperty dimensionProperty) {
		return dimensionPropertyDAO.makePersistent(dimensionProperty);
	}

	@Override
	public DimensionProperty getDimensionPropertyById(Long dimensionPropertyId) {
		return dimensionPropertyDAO.getDimensionPropertyInitialized(dimensionPropertyId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public DimensionProperty updateDimensionProperty(DimensionProperty dimensionProperty) {
		return dimensionPropertyDAO.saveOrUpdate(dimensionProperty);
	}

	@Override
	public DimensionProperty deleteDimensionProperty(Long dimensionPropertyId) {
		DimensionProperty dimensionProperty = dimensionPropertyDAO.getReference(dimensionPropertyId);
		dimensionPropertyDAO.delete(dimensionProperty);
		return dimensionProperty;
	}

	@Override
	public Set<DimensionProperty> getAllDimensionPropertys() {
		return dimensionPropertyDAO.findAllUnique();
	}

	@Override
	public DimensionProperty createDimensionProperty(String name, Media logoImage) {
		DimensionProperty dimensionProperty = new DimensionProperty();
		return dimensionProperty;
	}

	@Override
	public DimensionProperty getDimensionPropertyByName(String dimensionPropertyName) {
		return dimensionPropertyDAO.getDimensionPropertyByName(dimensionPropertyName);
	}

}
