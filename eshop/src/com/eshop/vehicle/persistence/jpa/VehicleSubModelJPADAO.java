/**
 * 
 */
package com.eshop.vehicle.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehicle.persistence.VehicleSubModelDAO;

/**
 * @author ssd1kor
 * 
 */
@Repository("vehicleSubModelJPADAO")
public class VehicleSubModelJPADAO extends GenericJPADAO<VehicleSubModel, Long> implements VehicleSubModelDAO {

	public VehicleSubModelJPADAO() {
		super(VehicleSubModel.class);
	}

	@Override
	public VehicleSubModel update(VehicleSubModel detachedVehicleSubModel) {
		VehicleSubModel persistentVehicleSubModel = update(detachedVehicleSubModel, false);
		return persistentVehicleSubModel;
	}

	@Override
	public VehicleSubModel update(VehicleSubModel detachedVehicleSubModel, Boolean flush) {
		VehicleSubModel persistentVehicleSubModel = findForUpdate(detachedVehicleSubModel.getId(), detachedVehicleSubModel.getVersion());
		persistentVehicleSubModel.setImages(detachedVehicleSubModel.getImages());
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedVehicleSubModel.getId() + " updated");
		}
		return persistentVehicleSubModel;
	}

	@Override
	public List<VehicleSubModel> getVehicleSubModelsForVehicleModel(Long vehicleModelId) {

		Query query = getEntityManager().createNamedQuery("getVehicleSubModelsForVehicleModel");
		query.setParameter("vehicleModelId", vehicleModelId);

		List<VehicleSubModel> vehicleSubModels = (List<VehicleSubModel>) query.getResultList();
		return vehicleSubModels;
	}

	@Override
	public VehicleSubModel getInitializedVehicleSubModel(Long vehicleSubModelId) {
		Query query = getEntityManager().createNamedQuery("getInitializedVehicleSubModel")
				.setParameter("vehicleSubModelId", vehicleSubModelId).setMaxResults(1);

		VehicleSubModel vehicleSubModel = (VehicleSubModel) query.getSingleResult();
		return vehicleSubModel;
	}

	
}
