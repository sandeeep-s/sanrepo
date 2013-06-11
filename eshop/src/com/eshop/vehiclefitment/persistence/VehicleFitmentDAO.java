package com.eshop.vehiclefitment.persistence;

import java.util.List;

import com.eshop.base.persistence.GenericDAO;
import com.eshop.vehiclefitment.model.VehicleFitment;

public interface VehicleFitmentDAO extends GenericDAO<VehicleFitment, Long> {

	public List<VehicleFitment> findByVehicleModel(Long vehicleModelId);

	public List<VehicleFitment> findByVehicleModel(Long vehicleModelId, Boolean isOriginalEquipment);

}
