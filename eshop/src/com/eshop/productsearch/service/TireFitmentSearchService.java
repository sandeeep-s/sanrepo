package com.eshop.productsearch.service;

import java.util.List;

import com.eshop.productsearch.form.TireFitmentForm;
import com.eshop.vehiclefitment.model.VehicleFitment;

public interface TireFitmentSearchService {

	public List<TireFitmentForm> searchFitmentByCategoryAndVehicleModel(Long categoryId, Long vehicleModelId, Boolean isOriginalEquipment);

	public List<VehicleFitment> searchFitmentByCategoryAndVehicleSubModel(Long categoryId, Long vehicleSubModelId, Boolean isOriginalEquipment);

}
