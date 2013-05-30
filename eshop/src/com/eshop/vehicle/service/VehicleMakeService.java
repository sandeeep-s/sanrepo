/**
 * 
 */
package com.eshop.vehicle.service;

import java.util.List;
import java.util.Set;

import com.eshop.common.model.Media;
import com.eshop.vehicle.model.VehicleMake;

/**
 * @author ssd1kor
 * 
 */
public interface VehicleMakeService {

	public VehicleMake addVehicleMake(VehicleMake vehicleMake);

	public VehicleMake getVehicleMakeById(Long vehicleMakeId);

	public VehicleMake updateVehicleMake(VehicleMake vehicleMake);

	public VehicleMake deleteVehicleMake(Long vehicleMakeId);

	public Set<VehicleMake> getAllVehicleMakes();

	public List<Integer> getModelYearsForMake(Long vehicleMakeId);
}
