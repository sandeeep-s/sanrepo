/**
 * 
 */
package com.etyre.vehicle.persistence;

import java.util.Set;

import com.etyre.base.persistence.GenericDAO;
import com.etyre.vehicle.model.Vehicle;


/**
 * @author ssd1kor
 * 
 */
public interface VehicleDAO extends GenericDAO<Vehicle, Long>{

	public Set<Vehicle> findVehiclesByMake(Long vehicleMakeId);
	
}
