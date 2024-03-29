package com.etyre.vehicle.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.etyre.vehicle.model.VehicleType;
import com.etyre.vehicle.persistence.VehicleTypeDAO;
import com.etyre.vehicle.service.VehicleTypeService;

@Service("vehicleTypeService")
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Inject
	private VehicleTypeDAO vehicleTypeDAO;

	public VehicleTypeDAO getVehicleTypeDAO() {
		return vehicleTypeDAO;
	}

	public void setVehicleTypeDAO(VehicleTypeDAO vehicleTypeDAO) {
		this.vehicleTypeDAO = vehicleTypeDAO;
	}

	@Override
	public VehicleType addVehicleType(VehicleType vehicleType) {
		return vehicleTypeDAO.makePersistent(vehicleType);
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
	public void deleteVehicleType(Long id) {
		VehicleType vehicleType = vehicleTypeDAO.getReference(id);
		vehicleTypeDAO.delete(vehicleType);
	}

	@Override
	public Set<VehicleType> getAllVehilceTypes() {
		return vehicleTypeDAO.findAllUnique();
	}

}
