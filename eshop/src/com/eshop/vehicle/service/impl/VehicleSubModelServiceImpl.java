/**
 * 
 */
package com.eshop.vehicle.service.impl;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.vehicle.factory.VehicleSubModelFactory;
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

	@Inject
	@Named("vehicleSubModelCommandFactory")
	private VehicleSubModelFactory vehicleSubModelFactory;

	@Override
	public VehicleSubModel addVehicleSubModel(VehicleSubModel vehicleSubModel) {
		return vehicleSubModelDAO.save(vehicleSubModel);
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

	@Override
	public VehicleSubModel createVehicleSubModel() {
		return vehicleSubModelFactory.createVehicleSubModel();
	}

}
