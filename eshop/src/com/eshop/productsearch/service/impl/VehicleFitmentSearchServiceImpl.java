package com.eshop.productsearch.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.productsearch.service.VehicleFitmentSearchService;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.persistence.VehicleFitmentDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class VehicleFitmentSearchServiceImpl implements VehicleFitmentSearchService{

	@Inject
	private VehicleFitmentDAO vehicleFitmentDAO;
	
	@Override
	public List<VehicleFitment> searchFitmentByCategoryAndVehicleModel(Long categoryId, Long vehicleModelId, Boolean isOriginalEquipment) {
		List<VehicleFitment> vehicleFitments = vehicleFitmentDAO.findByVehicleModel(vehicleModelId, isOriginalEquipment);
		return vehicleFitments;
	}

	@Override
	public List<VehicleFitment> searchFitmentByCategoryAndVehicleSubModel(Long categoryId, Long vehicleSubModelId,
			Boolean isOriginalEquipment) {
		// TODO Auto-generated method stub
		return null;
	}

}
