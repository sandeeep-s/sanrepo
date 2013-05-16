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
@Service("vehicleSubModelService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleSubModelServiceImpl implements VehicleSubModelService {

	@Inject
	private VehicleSubModelDAO vehicleSubModelDAO = null;

	public VehicleSubModelDAO getVehicleSubModelDAO() {
		return vehicleSubModelDAO;
	}

	public void setVehicleSubModelDAO(VehicleSubModelDAO vehicleSubModelDAO) {
		this.vehicleSubModelDAO = vehicleSubModelDAO;
	}

	@Override
	public VehicleSubModel addVehicleSubModel(VehicleSubModel vehicle) {
		return vehicleSubModelDAO.makePersistent(vehicle);
	}

	@Override
	public VehicleSubModel getVehicleSubModelById(Long vehicleId) {
		return vehicleSubModelDAO.findById(vehicleId);
	}

	@Override
	public VehicleSubModel updateVehicleSubModel(VehicleSubModel vehicle) {
		return vehicleSubModelDAO.saveOrUpdate(vehicle);
	}

	@Override
	public void deleteVehicleSubModel(Long vehicleId) {
		VehicleSubModel vehicle = vehicleSubModelDAO.getReference(vehicleId);
		vehicleSubModelDAO.delete(vehicle);
	}

	@Override
	public Set<VehicleSubModel> getAllVehicleSubModels() {
		return vehicleSubModelDAO.findAllUnique();
	}

}
