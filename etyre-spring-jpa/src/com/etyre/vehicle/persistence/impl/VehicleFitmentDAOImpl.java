package com.etyre.vehicle.persistence.impl;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.VehicleFitment;
import com.etyre.vehicle.persistence.VehicleFitmentDAO;

public class VehicleFitmentDAOImpl extends GenericDAOImpl<VehicleFitment, Long> implements VehicleFitmentDAO {

	public VehicleFitmentDAOImpl(){
		super(VehicleFitment.class);
	}
}
