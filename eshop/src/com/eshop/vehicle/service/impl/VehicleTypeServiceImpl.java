package com.eshop.vehicle.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.persistence.VehicleTypeDAO;
import com.eshop.vehicle.service.VehicleTypeService;

@Service("vehicleTypeService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Inject
	private VehicleTypeDAO vehicleTypeDAO;

	@Override
	public VehicleType addVehicleType(VehicleType vehicleType) {
		return vehicleTypeDAO.save(vehicleType);
	}

	@Override
	public VehicleType getVehicleTypeById(Long id) {
		return vehicleTypeDAO.findById(id);
	}

	@Override
	public VehicleType updateVehicleType(VehicleType vehicleType) {
		return vehicleTypeDAO.saveOrUpdate(vehicleType);
	}

	@Override
	public VehicleType deleteVehicleType(Long id) {
		VehicleType vehicleType = vehicleTypeDAO.getReference(id);
		vehicleTypeDAO.delete(vehicleType);
		return vehicleType;
	}

	@Override
	public Set<VehicleType> getAllVehicleTypes() {
		return vehicleTypeDAO.findAllUnique();
	}

}
