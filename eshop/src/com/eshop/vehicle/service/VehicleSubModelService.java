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

	public VehicleSubModel addVehicleSubModel(VehicleSubModel vehicleSubModel);

	public VehicleSubModel getVehicleSubModelById(Long vehicleSubModelId);

	public VehicleSubModel updateVehicleSubModel(VehicleSubModel vehicleSubModel);

	public VehicleSubModel deleteVehicleSubModel(Long vehicleId);

	public Set<VehicleSubModel> getAllVehicleSubModels();

	public VehicleSubModel createVehicleSubModel();

}
