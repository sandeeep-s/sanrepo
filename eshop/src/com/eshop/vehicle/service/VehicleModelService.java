/**
 * 
 */
package com.eshop.vehicle.service;

import java.util.List;
import java.util.Set;

import com.eshop.vehicle.model.VehicleModel;

/**
 * @author ssd1kor
 *
 */
public interface VehicleModelService {

	public VehicleModel addVehicleModel(VehicleModel vehicleModel);

	public VehicleModel getVehicleModelById(Long id);

	public VehicleModel updateVehicleModel(VehicleModel vehicleModel);

	public void deleteVehicleModel(Long id);

	public Set<VehicleModel> getAllVehicleModels();
	
	public List<Integer> getModelYearsForMake(Long vehicleMakeId);

	public List<VehicleModel> getVehicleModelForMakeAndYear(Long vehicleMakeId, Integer modelYear);

}
