package com.eshop.vehiclefitment.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.persistence.VehicleFitmentDAO;

@Repository
public class VehicleFitmentDAOImpl extends GenericDAOImpl<VehicleFitment, Long> implements VehicleFitmentDAO {

}
