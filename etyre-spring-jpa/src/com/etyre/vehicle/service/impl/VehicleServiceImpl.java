/**
 * 
 */
package com.etyre.vehicle.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.etyre.vehicle.model.Vehicle;
import com.etyre.vehicle.persistence.VehicleDAO;
import com.etyre.vehicle.service.VehicleService;

/**
 * @author ssd1kor
 * 
 */
@Service("vehicleService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleServiceImpl implements VehicleService {

	@Inject
	private VehicleDAO vehicleDAO = null;

	public VehicleDAO getVehicleDAO() {
		return vehicleDAO;
	}

	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleDAO.makePersistent(vehicle);
	}

	@Override
	public Vehicle getVehicleById(Long vehicleId) {
		return vehicleDAO.findById(vehicleId);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDAO.saveOrUpdate(vehicle);
	}

	@Override
	public void deleteVehicle(Long vehicleId) {
		Vehicle vehicle = vehicleDAO.getReference(vehicleId);
		vehicleDAO.delete(vehicle);
	}

	@Override
	public Set<Vehicle> getAllVehicles() {
		return vehicleDAO.findAllUnique();
	}

	@Override
	public Set<Vehicle> getAllVehiclesForMake(Long vehicleMakeId) {
		return vehicleDAO.findVehiclesByMake(vehicleMakeId);
	}

}
