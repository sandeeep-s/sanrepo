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

import com.eshop.catalog.admin.service.DimensionService;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.persistence.DimensionDAO;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("dimensionService")
@Transactional(propagation = Propagation.REQUIRED)
public class DimensionServiceImpl implements DimensionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DimensionServiceImpl.class);

	@Inject
	private DimensionDAO dimensionDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addDimension(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Dimension addDimension(Dimension dimension) {
		return dimensionDAO.makePersistent(dimension);
	}

	@Override
	public Dimension getDimensionById(Long dimensionId) {
		return dimensionDAO.findById(dimensionId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public Dimension updateDimension(Dimension dimension) {
		return dimensionDAO.saveOrUpdate(dimension);
	}

	@Override
	public void deleteDimension(Long dimensionId) {
		Dimension dimension = dimensionDAO.getReference(dimensionId);
		dimensionDAO.delete(dimension);
	}

	@Override
	public Set<Dimension> getAllDimensions() {
		return dimensionDAO.findAllUnique();
	}

	@Override
	public Dimension createDimension(String name, Media logoImage) {
		Dimension dimension = new Dimension();
		return dimension;
	}

}
