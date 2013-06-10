package com.eshop.vehicle.persistence.impl;

import java.util.List;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.persistence.VehicleModelDAO;

@Repository("vehicleModelDAO")
public class VehicleModelDAOImpl extends GenericDAOImpl<VehicleModel, Long> implements VehicleModelDAO {

	public VehicleModelDAOImpl() {
		super(VehicleModel.class);
	}

	@Override
	public List<Integer> getModelYearsForMake(Long vehicleMakeId) {

		Query query = getEntityManager().createNamedQuery("getModelYearsForMake");
		query.setParameter("vehicleMakeId", vehicleMakeId);

		List<Integer> modelYears = (List<Integer>) query.getResultList();
		return modelYears;
	}

	@Override
	public List<VehicleModel> getVehicleModelForMakeAndYear(Long vehicleMakeId, Integer modelYear) {

		Query query = getEntityManager().createNamedQuery("getVehicleModelForMakeAndYear");
		query.setParameter("vehicleMakeId", vehicleMakeId);
		query.setParameter("modelYear", modelYear);
//		query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);

		List<VehicleModel> vehicleModels = (List<VehicleModel>) query.getResultList();

		return vehicleModels;
	}

}
