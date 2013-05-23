package com.eshop.vehiclefitment.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehiclefitment.model.Fitment;
import com.eshop.vehiclefitment.persistence.FitmentDAO;

@Repository
public class FitmentDAOImpl extends GenericDAOImpl<Fitment, Long> implements FitmentDAO {

}
