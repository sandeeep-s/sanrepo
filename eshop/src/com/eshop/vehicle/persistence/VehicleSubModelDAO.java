/**
 * 
 */
package com.eshop.vehicle.persistence;

import java.util.Set;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.vehicle.model.VehicleSubModel;


/**
 * @author ssd1kor
 * 
 */
public interface VehicleSubModelDAO extends GenericDAO<VehicleSubModel, Long>{

	public Set<VehicleSubModel> findVehicleSubModelsByMake(Long vehicleMakeId);
	
}
