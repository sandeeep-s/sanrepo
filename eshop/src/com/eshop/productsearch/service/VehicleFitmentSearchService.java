package com.eshop.productsearch.service;

import java.util.List;

import com.eshop.vehiclefitment.model.VehicleFitment;

public interface VehicleFitmentSearchService {

	public List<VehicleFitment> searchFitmentByCategoryAndVehicleModel(Long categoryId, Long vehicleModelId, Boolean isOriginalEquipment);

	public List<VehicleFitment> searchFitmentByCategoryAndVehicleSubModel(Long categoryId, Long vehicleSubModelId, Boolean isOriginalEquipment);

}
