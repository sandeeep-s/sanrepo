package com.eshop.vehicle.factory.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eshop.common.model.Media;
import com.eshop.vehicle.factory.VehicleSubModelFactory;
import com.eshop.vehicle.model.VehicleSubModel;

@Component("vehicleSubModelCommandFactory")
public class VehicleSubModelCommandFactory implements VehicleSubModelFactory {

	@Override
	public VehicleSubModel createVehicleSubModel() {
		VehicleSubModel vehicleSubModel = new VehicleSubModel();
		List<Media> images = new ArrayList<Media>();
		images.add(new Media());
		images.add(new Media());
		vehicleSubModel.setImages(images);
		return vehicleSubModel;
	}

}
