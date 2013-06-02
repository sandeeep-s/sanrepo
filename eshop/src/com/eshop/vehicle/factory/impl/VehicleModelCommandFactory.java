package com.eshop.vehicle.factory.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import com.eshop.common.model.Media;
import com.eshop.vehicle.factory.VehicleModelFactory;
import com.eshop.vehicle.model.VehicleModel;

@Component("vehicleModelCommandFactory")
public class VehicleModelCommandFactory implements VehicleModelFactory {

	@Override
	public VehicleModel createVehicleModel() {
		VehicleModel vehicleModel = new VehicleModel();
		List<Media> images = new ArrayList<Media>();
		images.add(new Media());
		images.add(new Media());
		vehicleModel.setImages(images);
		return vehicleModel;
	}

}
