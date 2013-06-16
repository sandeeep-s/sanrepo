/**
 * 
 */
package com.eshop.vehicle.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.persistence.VehicleMakeDAO;

/**
 * @author ssd1kor
 * 
 */
@Repository("vehicleMakeJPADAO")
public class VehicleMakeJPADAO extends GenericJPADAO<VehicleMake, Long> implements VehicleMakeDAO {

	public VehicleMakeJPADAO() {
		super(VehicleMake.class);
	}

	@Override
	public List<Integer> getModelYearsForMake(Long vehicleMakeId) {
		Query q = getEntityManager().createNamedQuery("getModelYearsForMake").setParameter("vehicleMakeId", vehicleMakeId);
		List<Integer> modelYears = q.getResultList();
		return modelYears;
	}

	
	@Override
	public VehicleMake update(VehicleMake detachedInstance) {
		VehicleMake persistentVehicleMake = update(detachedInstance, false);
		return persistentVehicleMake;
	}

	/**
	 * Update method is overridden here to avoid incorrect usage of merge for updating. A call to merge will update an existing instance but also persists a new instance.
	 * So a call to merge may not be symantically match with update. 
	 * In the overridden method here we query for the object to be updated to get the persistent instance. Then we copy the values from detached object into the persistent object.
	 */
	@Override
	public VehicleMake update(VehicleMake detachedInstance, Boolean flush) {
		VehicleMake persistentVehicleMake = findForUpdate(detachedInstance.getId(), detachedInstance.getVersion());
		persistentVehicleMake.setLogoImage(detachedInstance.getLogoImage());
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedInstance.getId() + " updated");
		}
		return persistentVehicleMake;
	}

}
