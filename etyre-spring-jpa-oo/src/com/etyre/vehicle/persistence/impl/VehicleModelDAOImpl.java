package com.etyre.vehicle.persistence.impl;

import org.springframework.stereotype.Repository;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.VehicleModel;
import com.etyre.vehicle.persistence.VehicleModelDAO;

@Repository("vehicleModelDAO")
public class VehicleModelDAOImpl extends GenericDAOImpl<VehicleModel, Long> implements VehicleModelDAO {

	public VehicleModelDAOImpl() {
		super(VehicleModel.class);
	}

}
