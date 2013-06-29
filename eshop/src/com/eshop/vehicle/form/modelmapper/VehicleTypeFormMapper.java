package com.eshop.vehicle.form.modelmapper;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.vehicle.form.VehicleMakeForm;
import com.eshop.vehicle.form.VehicleTypeForm;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.persistence.VehicleTypeDAO;

@Component("vehicleTypeFormMapper")
public class VehicleTypeFormMapper implements FormModelMapper<VehicleTypeForm, VehicleType> {

	@Inject
	private VehicleTypeDAO vehicleTypeDAO;

	@Override
	public VehicleTypeForm mapModelToForm(VehicleType model) {
		VehicleTypeForm form = new VehicleTypeForm();
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		form.setName(model.getName());
		form.setImage(model.getImage());
		return form;
	}

	@Override
	public VehicleType mapFormToNewModel(VehicleTypeForm form) {
		VehicleType model = new VehicleType(form.getName(), form.getImage());
		return model;
	}

	@Override
	public VehicleType mapFormToExistingModel(VehicleTypeForm form) {
		VehicleType model = vehicleTypeDAO.findById(form.getId());
		model.setVersion(form.getVersion());
		model.setImage(form.getImage());
		return model;
	}

}