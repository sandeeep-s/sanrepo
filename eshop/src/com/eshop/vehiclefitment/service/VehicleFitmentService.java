package com.eshop.vehiclefitment.service;

import java.util.List;
import java.util.Set;

import com.eshop.vehiclefitment.model.VehicleFitment;

public interface VehicleFitmentService {

	public VehicleFitment addVehicleFitment(VehicleFitment vehicleFitment);

	public VehicleFitment getVehicleFitmentById(Long vehicleFitmentId);

	public VehicleFitment updateVehicleFitment(VehicleFitment vehicleFitment);

	public void deleteVehicleFitment(Long vehicleFitmentId);

	public Set<VehicleFitment> getAllVehicleFitments();

	public List<VehicleFitment> getVehicleFitmentsForVehicleModel(Long vehicleModelId);

	public VehicleFitment createVehicleFitment();
}
