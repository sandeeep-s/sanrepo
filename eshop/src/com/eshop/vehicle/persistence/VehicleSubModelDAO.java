/**
 * 
 */
package com.eshop.vehicle.persistence;

import java.util.List;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.vehicle.model.VehicleSubModel;

/**
 * @author ssd1kor
 * 
 */
public interface VehicleSubModelDAO extends GenericDAO<VehicleSubModel, Long> {

	public List<VehicleSubModel> getVehicleSubModelsForVehicleModel(Long vehicleModelId);
	
	public VehicleSubModel getInitializedVehicleSubModel(Long vehicleSubModelId);

}
