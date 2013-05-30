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
	public VehicleSubModel addVehicleSubModel(VehicleSubModel vehicleSubModel) {
		return vehicleSubModelDAO.makePersistent(vehicleSubModel);
	}

	@Override
	public VehicleSubModel getVehicleSubModelById(Long vehicleSubModelId) {
		return vehicleSubModelDAO.getInitializedVehicleSubModel(vehicleSubModelId);
	}

	@Override
	public VehicleSubModel updateVehicleSubModel(VehicleSubModel vehicleSubModel) {
		return vehicleSubModelDAO.saveOrUpdate(vehicleSubModel);
	}

	@Override
	public VehicleSubModel deleteVehicleSubModel(Long vehicleSubModelId) {
		VehicleSubModel vehicleSubModel = vehicleSubModelDAO.getReference(vehicleSubModelId);
		vehicleSubModelDAO.delete(vehicleSubModel);
		return vehicleSubModel;
	}

	@Override
	public Set<VehicleSubModel> getAllVehicleSubModels() {
		return vehicleSubModelDAO.findAllUnique();
	}

}
