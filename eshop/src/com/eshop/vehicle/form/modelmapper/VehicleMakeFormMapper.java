package com.eshop.vehicle.form.modelmapper;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

import com.eshop.vehicle.form.VehicleMakeForm;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.persistence.VehicleMakeDAO;

@Component("vehicleMakeFormMapper")
public class VehicleMakeFormMapper implements FormModelMapper<VehicleMakeForm, VehicleMake> {

	@Inject
	private VehicleMakeDAO vehicleMakeDAO;

	@Override
	public VehicleMakeForm mapModelToForm(VehicleMake model) {
		VehicleMakeForm form = new VehicleMakeForm();
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		form.setName(model.getName());
		form.setLogoImage(model.getLogoImage());
		return form;
	}

	@Override
	public VehicleMake mapFormToNewModel(VehicleMakeForm form) {
		VehicleMake model = new VehicleMake(form.getName(), form.getLogoImage());
		return model;
	}

	@Override
	public VehicleMake mapFormToExistingModel(VehicleMakeForm form) {
		VehicleMake model = vehicleMakeDAO.findById(form.getId());
		model.setVersion(form.getVersion());
		model.setLogoImage(form.getLogoImage());
		return model;
	}

}
