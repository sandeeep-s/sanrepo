/**
 * 
 */
package com.etyre.vehicle.service;

import java.util.Set;

import com.etyre.vehicle.model.Vehicle;

/**
 * @author ssd1kor
 * 
 */
public interface VehicleService {

	public Vehicle addVehicle(Vehicle vehicle);

	public Vehicle getVehicleById(Long vehicleId);

	public Vehicle updateVehicle(Vehicle vehicle);

	public void deleteVehicle(Long vehicleId);

	public Set<Vehicle> getAllVehicles();

	public Set<Vehicle> getAllVehiclesForMake(Long vehicleMakeId);


}
