/**
 * 
 */
package com.etyre.vehicle.persistence.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.VehicleSubModel;
import com.etyre.vehicle.persistence.VehicleSubModelDAO;

/**
 * @author ssd1kor
 * 
 */
@Repository("vehicleDAO")
public class VehicleSubModelDAOImpl extends GenericDAOImpl<VehicleSubModel, Long> implements VehicleSubModelDAO {

    public VehicleSubModelDAOImpl()
    {
        super(VehicleSubModel.class);
    }

	
	@Override
	@SuppressWarnings("unchecked")
	public Set<VehicleSubModel> findVehicleSubModelsByMake(Long vehicleMakeId) {
		Set<VehicleSubModel> vehicleSet = null;
/*		Query q = getEntityManager().getNamedQuery("getVehicleSubModelsByMake");
		q.setLong("vehicleMakeId", vehicleMakeId);
		List<VehicleSubModel> vehicleList = q.list();
		vehicleSet = new HashSet<VehicleSubModel>();
		vehicleSet.addAll(vehicleList);
*/
		return vehicleSet;
	}

}
