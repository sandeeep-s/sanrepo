/**
 * 
 */
package com.eshop.vehicle.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehicle.persistence.VehicleSubModelDAO;
import com.eshop.vehicle.service.VehicleSubModelService;

/**
 * @author ssd1kor
 * 
 */
@Service("vehicleService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleSubModelServiceImpl implements VehicleSubModelService {

	@Inject
	private VehicleSubModelDAO vehicleDAO = null;

	public VehicleSubModelDAO getVehicleSubModelDAO() {
		return vehicleDAO;
	}

	public void setVehicleSubModelDAO(VehicleSubModelDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

	@Override
	public VehicleSubModel addVehicleSubModel(VehicleSubModel vehicle) {
		return vehicleDAO.makePersistent(vehicle);
	}

	@Override
	public VehicleSubModel getVehicleSubModelById(Long vehicleId) {
		return vehicleDAO.findById(vehicleId);
	}

	@Override
	public VehicleSubModel updateVehicleSubModel(VehicleSubModel vehicle) {
		return vehicleDAO.saveOrUpdate(vehicle);
	}

	@Override
	public void deleteVehicleSubModel(Long vehicleId) {
		VehicleSubModel vehicle = vehicleDAO.getReference(vehicleId);
		vehicleDAO.delete(vehicle);
	}

	@Override
	public Set<VehicleSubModel> getAllVehicleSubModels() {
		return vehicleDAO.findAllUnique();
	}

	@Override
	public Set<VehicleSubModel> getAllVehicleSubModelsForMake(Long vehicleMakeId) {
		return vehicleDAO.findVehicleSubModelsByMake(vehicleMakeId);
	}

}
