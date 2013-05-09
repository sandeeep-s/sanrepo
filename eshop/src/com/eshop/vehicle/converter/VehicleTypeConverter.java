package com.eshop.vehicle.converter;

import javax.inject.Inject;
import org.springframework.core.convert.converter.Converter;

import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.service.VehicleTypeService;

public class VehicleTypeConverter implements Converter<String, VehicleType> {

	@Inject
	private VehicleTypeService vehicleTypeService;

	public VehicleTypeService getVehicleTypeService() {
		return vehicleTypeService;
	}

	public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
		this.vehicleTypeService = vehicleTypeService;
	}

	@Override
	public VehicleType convert(String id) {
		return vehicleTypeService.getVehicleTypeById(Long.valueOf(id));
	}

}
