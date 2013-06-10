/**
 * 
 */
package com.eshop.vehicle.persistence;

import java.util.List;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.vehicle.model.VehicleMake;

/**
 * @author ssd1kor
 * 
 */
public interface VehicleMakeDAO extends GenericDAO<VehicleMake, Long> {
	
	public List<Integer> getModelYearsForMake(Long vehicleMakeId);
	
	public VehicleMake updateVehicleMake(VehicleMake detachedVehicleMake);	
}
