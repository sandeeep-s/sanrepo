package com.eshop.vehicle.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.vehicle.form.VehicleSubModelForm;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehicle.persistence.VehicleSubModelDAO;

@Component("vehicleSubModelFormMapper")
public class VehicleSubModelFormMapper implements FormModelMapper<VehicleSubModelForm, VehicleSubModel> {

	@Inject
	private VehicleSubModelDAO vehicleSubModelDAO;
	
	@Override
	public VehicleSubModelForm mapModelToForm(VehicleSubModel model) {
		VehicleSubModelForm vehicleSubModelForm = new VehicleSubModelForm();
		vehicleSubModelForm.setId(model.getId());
		vehicleSubModelForm.setVersion(model.getVersion());
		vehicleSubModelForm.setName(model.getName());
		vehicleSubModelForm.setVehicleModel(model.getVehicleModel());
		vehicleSubModelForm.setImages(model.getImages());
		return vehicleSubModelForm;
	}

	@Override
	public VehicleSubModel mapFormToNewModel(VehicleSubModelForm form) {
		VehicleSubModel model = new VehicleSubModel(form.getVehicleModel(), form.getName(), form.getImages());
		return model;
	}

	@Override
	public VehicleSubModel mapFormToExistingModel(VehicleSubModelForm form) {
		VehicleSubModel model = vehicleSubModelDAO.findById(form.getId());
		model.setVersion(form.getVersion());
		model.setImages(form.getImages());
		return model;
	}

}
