package com.eshop.vehiclefitment.factory.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eshop.vehiclefitment.factory.VehicleFitmentFactory;
import com.eshop.vehiclefitment.model.VehicleFitment;
import com.eshop.vehiclefitment.model.FitmentComponent;
import com.eshop.vehiclefitment.model.VehicleFitment;

@Component("vehicleFitmentFactory")
public class VehicleFitmentFactoryImpl implements VehicleFitmentFactory {

	@Override
	public VehicleFitment createVehicleFitment() {

		VehicleFitment vehicleFitment = new VehicleFitment();

		List<FitmentComponent> fitmentComponents = new ArrayList<FitmentComponent>();

		FitmentComponent fitmentComponent = new FitmentComponent();
		fitmentComponents.add(fitmentComponent);

		vehicleFitment.setFitmentComponents(fitmentComponents);

		return vehicleFitment;
	}

}
