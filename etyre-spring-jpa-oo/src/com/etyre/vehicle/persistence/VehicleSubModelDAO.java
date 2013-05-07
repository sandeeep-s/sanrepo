/**
 * 
 */
package com.etyre.vehicle.persistence;

import java.util.Set;

import com.etyre.base.persistence.GenericDAO;
import com.etyre.vehicle.model.VehicleSubModel;


/**
 * @author ssd1kor
 * 
 */
public interface VehicleSubModelDAO extends GenericDAO<VehicleSubModel, Long>{

	public Set<VehicleSubModel> findVehicleSubModelsByMake(Long vehicleMakeId);
	
}
