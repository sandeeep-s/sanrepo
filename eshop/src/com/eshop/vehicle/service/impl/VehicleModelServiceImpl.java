/**
 * 
 */
package com.eshop.vehicle.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.persistence.VehicleModelDAO;
import com.eshop.vehicle.service.VehicleModelService;

/**
 * @author ssd1kor
 *
 */
@Service("vehicleModelService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleModelServiceImpl implements VehicleModelService {

	@Inject
	private VehicleModelDAO vehicleModelDAO;

	public VehicleModelDAO getVehicleModelDAO() {
		return vehicleModelDAO;
	}

	public void setVehicleModelDAO(VehicleModelDAO vehicleModelDAO) {
		this.vehicleModelDAO = vehicleModelDAO;
	}

	@Override
	public VehicleModel addVehicleModel(VehicleModel vehicleModel) {
		return vehicleModelDAO.makePersistent(vehicleModel);
	}

	@Override
	public VehicleModel getVehicleModelById(Long id) {
		return vehicleModelDAO.findById(id);
	}

	@Override
	public VehicleModel updateVehicleModel(VehicleModel vehicleModel) {
		return vehicleModelDAO.saveOrUpdate(vehicleModel);
	}

	@Override
	public VehicleModel deleteVehicleModel(Long id) {
		VehicleModel vehicleModel = vehicleModelDAO.getReference(id);
		vehicleModelDAO.delete(vehicleModel);
		return vehicleModel;
	}

	@Override
	public Set<VehicleModel> getAllVehicleModels() {
		return vehicleModelDAO.findAllUnique();
	}

	@Override
	public List<Integer> getModelYearsForMake(Long vehicleMakeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleModel> getVehicleModelForMakeAndYear(Long vehicleMakeId, Integer modelYear) {
		return vehicleModelDAO.getVehicleModelForMakeAndYear(vehicleMakeId, modelYear);
	}

}
