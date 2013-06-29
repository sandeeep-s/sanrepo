/**
 * 
 */
package com.eshop.vehiclefitment.service;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.vehiclefitment.factory.VehicleFitmentFactory;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.persistence.VehicleFitmentDAO;

/**
 * @author ssd1kor
 * 
 */
@Service("vehicleFitmentService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleFitmentServiceImpl implements VehicleFitmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleFitmentServiceImpl.class);

	@Inject
	private VehicleFitmentDAO vehicleFitmentDAO;

	@Inject
	private VehicleFitmentFactory vehicleFitmentFactory;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addVehicleFitment(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public VehicleFitment addVehicleFitment(VehicleFitment vehicleFitment) {
		return vehicleFitmentDAO.save(vehicleFitment);
	}

	@Override
	public VehicleFitment getVehicleFitmentById(Long vehicleFitmentId) {
		return vehicleFitmentDAO.findById(vehicleFitmentId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public VehicleFitment updateVehicleFitment(VehicleFitment vehicleFitment) {
		return vehicleFitmentDAO.saveOrUpdate(vehicleFitment);
	}

	@Override
	public void deleteVehicleFitment(Long vehicleFitmentId) {
		VehicleFitment vehicleFitment = vehicleFitmentDAO.getReference(vehicleFitmentId);
		vehicleFitmentDAO.delete(vehicleFitment);
	}

	@Override
	public Set<VehicleFitment> getAllVehicleFitments() {
		return vehicleFitmentDAO.findAllUnique();
	}

	public List<VehicleFitment> getVehicleFitmentsForVehicleModel(Long vehicleModelId){
		return vehicleFitmentDAO.findByVehicleModel(vehicleModelId);
	}
	
	public VehicleFitment createVehicleFitment() {
		return vehicleFitmentFactory.createVehicleFitment();
	}
}
