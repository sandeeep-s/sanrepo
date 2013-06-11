package com.eshop.vehiclefitment.persistence.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.persistence.VehicleFitmentDAO;

@Repository
public class VehicleFitmentDAOImpl extends GenericDAOImpl<VehicleFitment, Long> implements VehicleFitmentDAO {

	public VehicleFitmentDAOImpl(){
		super(VehicleFitment.class);
	}
	
	public List<VehicleFitment> findByVehicleModel(Long vehicleModelId){
		
		Query q = getEntityManager().createNamedQuery("findAllVehicleFitmentsForVehicleModel");
		q.setParameter("vehicleModelId", vehicleModelId);
		List<VehicleFitment> vehicleFitments =  (List<VehicleFitment>)q.getResultList();
		return vehicleFitments;
	}

	@Override
	public List<VehicleFitment> findByVehicleModel(Long vehicleModelId, Boolean isOriginalEquipment) {
		Query q = getEntityManager().createNamedQuery("getFitmentsForVehicleModel");
		q.setParameter("vehicleModelId", vehicleModelId);
		q.setParameter("originalEquipment", isOriginalEquipment);
		List<VehicleFitment> vehicleFitments =  (List<VehicleFitment>)q.getResultList();
		return vehicleFitments;
	}
	
}
