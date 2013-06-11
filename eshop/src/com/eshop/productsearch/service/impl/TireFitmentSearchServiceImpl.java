package com.eshop.productsearch.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.model.Dimension;
import com.eshop.productsearch.form.TireFitmentComponentForm;
import com.eshop.productsearch.form.TireFitmentForm;
import com.eshop.productsearch.service.TireFitmentSearchService;
import com.eshop.productsearch.service.VehicleFitmentSearchService;
import com.eshop.vehiclefitment.model.FitmentComponent;
import com.eshop.vehiclefitment.model.VehicleFitment;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class TireFitmentSearchServiceImpl implements TireFitmentSearchService {

	@Inject
	private VehicleFitmentSearchService vehicleFitmentSearchService;

	@Override
	public List<TireFitmentForm> searchFitmentByCategoryAndVehicleModel(Long categoryId, Long vehicleModelId, Boolean isOriginalEquipment) {

		//find original vehicle fitment objects for the vehicle model
		List<VehicleFitment> vehicleFitments = vehicleFitmentSearchService.searchFitmentByCategoryAndVehicleModel(categoryId, vehicleModelId, isOriginalEquipment);

		//Convert vehicle fitments into displayable fitment info.
		List<TireFitmentForm> tireFitmentForms = createTireFitmentFormsFromVehicleFitment(vehicleFitments);

		//Remove duplicate fitment infos.
		tireFitmentForms = new ArrayList<TireFitmentForm>(new LinkedHashSet<TireFitmentForm>(tireFitmentForms));

		return tireFitmentForms;
	}

	public List<TireFitmentForm> createTireFitmentFormsFromVehicleFitment(List<VehicleFitment> vehicleFitments) {
		List<TireFitmentForm> tireFitmentForms = new ArrayList<TireFitmentForm>();
		for (VehicleFitment vehicleFitment : vehicleFitments) {
			TireFitmentForm tireFitmentForm = createTireFitmentFormsFromVehicleFitment(vehicleFitment);
			tireFitmentForms.add(tireFitmentForm);
		}

		return tireFitmentForms;
	}

	public TireFitmentForm createTireFitmentFormsFromVehicleFitment(VehicleFitment vehicleFitment) {
		TireFitmentForm tireFitmentForm = new TireFitmentForm();
		List<TireFitmentComponentForm> fitmentComponentForms = new ArrayList<TireFitmentComponentForm>();
		for (FitmentComponent fitmentComponent : vehicleFitment.getFitmentComponents()) {

			TireFitmentComponentForm tfForm = createTireFitmentComponentFormsFromVehicleFitmentComponent(fitmentComponent);
			fitmentComponentForms.add(tfForm);
		}
		tireFitmentForm.setFitmentComponentForms(fitmentComponentForms);
		return tireFitmentForm;
	}

	public TireFitmentComponentForm createTireFitmentComponentFormsFromVehicleFitmentComponent(FitmentComponent fitmentComponent) {
		TireFitmentComponentForm tfForm = new TireFitmentComponentForm();
		tfForm.setPosition(fitmentComponent.getPosition());
		List<Dimension> dimensions = fitmentComponent.getProduct().getProductSpec().getDimensions();
		for (Dimension dimension : dimensions) {
			if ("Section".equalsIgnoreCase(dimension.getDimensionProperty().getName())) {
				tfForm.setSection(dimension.getDimensionValue());
			}
			if ("AspectRatio".equalsIgnoreCase(dimension.getDimensionProperty().getName())) {
				tfForm.setAspectRatio(dimension.getDimensionValue());
			}
			if ("Diameter".equalsIgnoreCase(dimension.getDimensionProperty().getName())) {
				tfForm.setDiameter(dimension.getDimensionValue());
			}
		}
		return tfForm;
	}

	@Override
	public List<VehicleFitment> searchFitmentByCategoryAndVehicleSubModel(Long categoryId, Long vehicleSubModelId,
			Boolean isOriginalEquipment) {
		// TODO Auto-generated method stub
		return null;
	}

}
