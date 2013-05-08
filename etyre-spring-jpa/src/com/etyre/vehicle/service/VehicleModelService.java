/**
 * 
 */
package com.etyre.vehicle.service;

import java.util.Set;

import com.etyre.vehicle.model.VehicleModel;

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

}
