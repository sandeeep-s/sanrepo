/**
 * 
 */
package com.eshop.vehicle.service;

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

	public void deleteVehicleMake(Long vehicleMakeId);

	public Set<VehicleMake> getAllVehicleMakes();

	public VehicleMake createVehicleMake(String vehicleMakeName, Media logoImage);

}
