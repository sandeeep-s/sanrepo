package com.eshop.productsearch.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.eshop.catalog.model.Product;
import com.eshop.productsearch.form.TireFitmentForm;
import com.eshop.vehiclefitment.model.VehicleFitment;

public interface TireFitmentSearchService {

	public List<TireFitmentForm> searchFitmentByCategoryAndVehicleModel(Long categoryId, Long vehicleModelId, Boolean isOriginalEquipment);

	public List<VehicleFitment> searchFitmentByCategoryAndVehicleSubModel(Long categoryId, Long vehicleSubModelId,
			Boolean isOriginalEquipment);

	public List<Product> searchTiresByDimensions(String section, String aspectRatio, String diameter);

	public List<Product> searchOriginalTiresByDimensions(String section, String aspectRatio, String diameter, Long vehicleModelId);

}
