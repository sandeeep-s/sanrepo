package com.eshop.vehicle.service;

import java.util.Set;

import com.eshop.vehicle.model.VehicleType;

public interface VehicleTypeService {

	public VehicleType addVehicleType(VehicleType vehicleType);

	public VehicleType getVehicleTypeById(Long id);

	public VehicleType updateVehicleType(VehicleType vehicleType);

	public void deleteVehicleType(Long id);

	public Set<VehicleType> getAllVehilceTypes();

}
