package com.eshop.vehicle.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericJPADAO;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.persistence.VehicleModelDAO;

@Repository("vehicleModelJPADAO")
public class VehicleModelJPADAO extends GenericJPADAO<VehicleModel, Long> implements VehicleModelDAO {

	public VehicleModelJPADAO() {
		super(VehicleModel.class);
	}

	@Override
	public VehicleModel update(VehicleModel detachedVehicleModel) {
		VehicleModel persistentVehicleModel = update(detachedVehicleModel, false);
		return persistentVehicleModel;
	}

	@Override
	public VehicleModel update(VehicleModel detachedVehicleModel, Boolean flush) {
		VehicleModel persistentVehicleModel = findForUpdate(detachedVehicleModel.getId(), detachedVehicleModel.getVersion());
		persistentVehicleModel.setImages(detachedVehicleModel.getImages());
		if (flush) {
			getEntityManager().flush();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("The entity of type " + type + " with id " + detachedVehicleModel.getId() + " updated");
		}
		return persistentVehicleModel;
	}

	@Override
	public List<Integer> getModelYearsForMake(Long vehicleMakeId) {

		Query query = getEntityManager().createNamedQuery("getModelYearsForMake");
		query.setParameter("vehicleMakeId", vehicleMakeId);

		List<Integer> modelYears = query.getResultList();
		return modelYears;
	}

	@Override
	public List<VehicleModel> getVehicleModelForMakeAndYear(Long vehicleMakeId, Integer modelYear) {

		Query query = getEntityManager().createNamedQuery("getVehicleModelForMakeAndYear");
		query.setParameter("vehicleMakeId", vehicleMakeId);
		query.setParameter("modelYear", modelYear);
//		query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);

		List<VehicleModel> vehicleModels = query.getResultList();

		return vehicleModels;
	}

}
