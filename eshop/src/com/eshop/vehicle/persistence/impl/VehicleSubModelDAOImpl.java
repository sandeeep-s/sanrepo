/**
 * 
 */
package com.eshop.vehicle.persistence.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehicle.persistence.VehicleSubModelDAO;

/**
 * @author ssd1kor
 * 
 */
@Repository("vehicleSubModelDAO")
public class VehicleSubModelDAOImpl extends GenericDAOImpl<VehicleSubModel, Long> implements VehicleSubModelDAO {

	public VehicleSubModelDAOImpl() {
		super(VehicleSubModel.class);
	}

	@Override
	public List<VehicleSubModel> getVehicleSubModelsForVehicleModel(Long vehicleModelId) {

		Query query = getEntityManager().createNamedQuery("getVehicleSubModelsForVehicleModel");
		query.setParameter("vehicleModelId", vehicleModelId);

		List<VehicleSubModel> vehicleSubModels = (List<VehicleSubModel>) query.getResultList();
		return vehicleSubModels;
	}

}
