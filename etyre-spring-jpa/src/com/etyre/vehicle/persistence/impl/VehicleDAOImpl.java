/**
 * 
 */
package com.etyre.vehicle.persistence.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.Vehicle;
import com.etyre.vehicle.persistence.VehicleDAO;

/**
 * @author ssd1kor
 * 
 */
@Repository("vehicleDAO")
public class VehicleDAOImpl extends GenericDAOImpl<Vehicle, Long> implements VehicleDAO {

    public VehicleDAOImpl()
    {
        super(Vehicle.class);
    }

	
	@Override
	@SuppressWarnings("unchecked")
	public Set<Vehicle> findVehiclesByMake(Long vehicleMakeId) {
		Set<Vehicle> vehicleSet = null;
/*		Query q = getEntityManager().getNamedQuery("getVehiclesByMake");
		q.setLong("vehicleMakeId", vehicleMakeId);
		List<Vehicle> vehicleList = q.list();
		vehicleSet = new HashSet<Vehicle>();
		vehicleSet.addAll(vehicleList);
*/
		return vehicleSet;
	}

}
