/**
 * 
 */
package com.eshop.vehicle.service;

import java.util.Set;

import com.eshop.vehicle.model.VehicleSubModel;

/**
 * @author ssd1kor
 * 
 */
public interface VehicleSubModelService {

	public VehicleSubModel addVehicleSubModel(VehicleSubModel vehicle);

	public VehicleSubModel getVehicleSubModelById(Long vehicleId);

	public VehicleSubModel updateVehicleSubModel(VehicleSubModel vehicle);

	public void deleteVehicleSubModel(Long vehicleId);

	public Set<VehicleSubModel> getAllVehicleSubModels();

}
