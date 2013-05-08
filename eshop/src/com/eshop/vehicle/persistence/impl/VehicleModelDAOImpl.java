package com.eshop.vehicle.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.persistence.VehicleModelDAO;

@Repository("vehicleModelDAO")
public class VehicleModelDAOImpl extends GenericDAOImpl<VehicleModel, Long> implements VehicleModelDAO {

	public VehicleModelDAOImpl() {
		super(VehicleModel.class);
	}

}
