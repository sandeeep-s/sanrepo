package com.eshop.vehicle.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.service.VehicleMakeService;

public class VehicleMakeConverter implements Converter<String, VehicleMake> {

	@Inject
	@Named("vehicleMakeService")
	private VehicleMakeService vehicleMakeService;

	public VehicleMakeService getVehicleMakeService() {
		return vehicleMakeService;
	}

	public void setVehicleMakeService(VehicleMakeService vehicleMakeService) {
		this.vehicleMakeService = vehicleMakeService;
	}

	@Override
	public VehicleMake convert(String id) {
		return vehicleMakeService.getVehicleMakeById(Long.valueOf(id));
	}

}
