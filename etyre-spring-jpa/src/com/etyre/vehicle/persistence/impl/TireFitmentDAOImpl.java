package com.etyre.vehicle.persistence.impl;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.TireFitment;
import com.etyre.vehicle.persistence.TireFitmentDAO;

public class TireFitmentDAOImpl extends GenericDAOImpl<TireFitment, Long> implements TireFitmentDAO {

	public TireFitmentDAOImpl() {
		super(TireFitment.class);
	}
}
