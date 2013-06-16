/**
 * 
 */
package com.eshop.vehicle.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.persistence.VehicleTypeDAO;

/**
 * @author ssd1kor
 *
 */
@Repository("vehicleTypeJPADAO")
public class VehicleTypeJPADAO extends GenericJPADAO<VehicleType, Long> implements VehicleTypeDAO{
	
	public VehicleTypeJPADAO(){
		super(VehicleType.class);
	}

	@Override
	public VehicleType update(VehicleType detachedVehicleType) {
		VehicleType persistentVehicleType = update(detachedVehicleType, false);
		return persistentVehicleType;
	}

	@Override
	public VehicleType update(VehicleType detachedVehicleType, Boolean flush) {
		VehicleType persistentVehicleType = findForUpdate(detachedVehicleType.getId(), detachedVehicleType.getVersion());
		persistentVehicleType.setImage(detachedVehicleType.getImage());
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedVehicleType.getId() + " updated");
		}
		return persistentVehicleType;
	}

}
