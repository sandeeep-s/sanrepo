package com.eshop.vehiclefitment.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.vehiclefitment.form.VehicleFitmentForm;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.service.VehicleFitmentService;

@Component("vehicleFitmentFormMapper")
public class VehicleFitmentFormMapper implements FormModelMapper<VehicleFitmentForm, VehicleFitment> {

	@Inject
	private VehicleFitmentService vehicleFitmentService;

	@Override
	public VehicleFitmentForm mapModelToForm(VehicleFitment model) {
		VehicleFitmentForm form = new VehicleFitmentForm(model.getVehicleModel(), model.getVehicleSubModel(), model.getFitmentComponents(),
				model.getOriginalEquipment());
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		return form;
	}

	@Override
	public VehicleFitment mapFormToNewModel(VehicleFitmentForm form) {
		VehicleFitment model = new VehicleFitment(form.getVehicleModel(), form.getVehicleSubModel(), form.getFitmentComponents(),
				form.getOriginalEquipment());
		return model;
	}

	@Override
	public VehicleFitment mapFormToExistingModel(VehicleFitmentForm form) {
		VehicleFitment model = vehicleFitmentService.getVehicleFitmentById(form.getId());
		model.setVersion(form.getVersion());
		model.setFitmentComponents(form.getFitmentComponents());
		model.setOriginalEquipment(form.getOriginalEquipment());
		return model;
	}

}
