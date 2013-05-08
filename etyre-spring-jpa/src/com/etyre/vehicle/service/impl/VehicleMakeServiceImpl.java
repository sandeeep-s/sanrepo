/**
 * 
 */
package com.etyre.vehicle.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.etyre.vehicle.model.VehicleMake;
import com.etyre.vehicle.persistence.VehicleMakeDAO;
import com.etyre.vehicle.service.VehicleMakeService;

/**
 * @author ssd1kor
 * 
 */
@Service("vehicleMakeService")
@Transactional(propagation=Propagation.REQUIRED)
public class VehicleMakeServiceImpl implements VehicleMakeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleMakeServiceImpl.class); 
	
	@Inject
	private VehicleMakeDAO vehicleMakeDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addVehicleMake(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public VehicleMake addVehicleMake(VehicleMake vehicleMake) {
		return vehicleMakeDAO.makePersistent(vehicleMake);
	}

	@Override
	public VehicleMake getVehicleMakeById(Long vehicleMakeId) {
		return vehicleMakeDAO.findById(vehicleMakeId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public VehicleMake updateVehicleMake(VehicleMake vehicleMake) {
		return vehicleMakeDAO.saveOrUpdate(vehicleMake);
	}

	@Override
	public void deleteVehicleMake(Long vehicleMakeId) {
		VehicleMake vehicleMake = vehicleMakeDAO.getReference(vehicleMakeId);
		vehicleMakeDAO.delete(vehicleMake);
	}

	@Override
	public Set<VehicleMake> getAllVehicleMakes() {
		return vehicleMakeDAO.findAllUnique();
	}

}
