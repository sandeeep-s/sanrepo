package com.eshop.vehicle.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.vehicle.form.VehicleModelForm;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.persistence.VehicleModelDAO;

@Component("vehicleModelFormMapper")
public class VehicleModelFormMapper implements FormModelMapper<VehicleModelForm, VehicleModel> {

	@Inject
	private VehicleModelDAO vehicleModelDAO;

	@Override
	public VehicleModelForm mapModelToForm(VehicleModel model) {
		VehicleModelForm form = new VehicleModelForm();
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		form.setName(model.getName());
		form.setVehicleMake(model.getVehicleMake());
		form.setVehicleType(model.getVehicleType());
		form.setModelYear(model.getModelYear());
		form.setImages(model.getImages());
		return form;
	}

	@Override
	public VehicleModel mapFormToNewModel(VehicleModelForm form) {
		VehicleModel model = new VehicleModel(form.getName(), form.getModelYear(), form.getImages(), form.getVehicleType(),
				form.getVehicleMake());
		return model;
	}

	@Override
	public VehicleModel mapFormToExistingModel(VehicleModelForm form) {
		VehicleModel model = vehicleModelDAO.findById(form.getId());
		model.setVersion(form.getVersion());
		model.setImages(form.getImages());
		return model;
	}

}
