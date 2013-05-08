/**
 * 
 */
package com.etyre.vehicle.service;

import java.util.Set;

import com.etyre.vehicle.model.VehicleMake;


/**
 * @author ssd1kor
 * 
 */
public interface VehicleMakeService {

	public VehicleMake addVehicleMake(VehicleMake vehicleMake);

	public VehicleMake getVehicleMakeById(Long vehicleMakeId);

	public VehicleMake updateVehicleMake(VehicleMake vehicleMake);

	public void deleteVehicleMake(Long vehicleMakeId);

	public Set<VehicleMake> getAllVehicleMakes();

}
