/**
 * 
 */
package com.eshop.vehicle.persistence;

import java.util.List;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.vehicle.model.VehicleModel;

/**
 * @author ssd1kor
 *
 */
public interface VehicleModelDAO extends GenericDAO<VehicleModel, Long> {

	public List<Integer> getModelYearsForMake(Long vehicleMakeId);
	
	public List<VehicleModel> getVehicleModelForMakeAndYear(Long vehicleMakeId, Integer modelYear);
	
	

}
