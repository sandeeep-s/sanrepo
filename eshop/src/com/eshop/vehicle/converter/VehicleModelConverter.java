package com.eshop.vehicle.converter;

import javax.inject.Inject;
import org.springframework.core.convert.converter.Converter;

import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.service.VehicleModelService;

public class VehicleModelConverter implements Converter<String, VehicleModel> {

	@Inject
	private VehicleModelService vehicleModelService;

	public VehicleModelService getVehicleModelService() {
		return vehicleModelService;
	}

	public void setVehicleModelService(VehicleModelService vehicleModelService) {
		this.vehicleModelService = vehicleModelService;
	}

	@Override
	public VehicleModel convert(String id) {
		return vehicleModelService.getVehicleModelById(Long.valueOf(id));
	}

}
