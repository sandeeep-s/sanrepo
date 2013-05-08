/**
 * 
 */
package com.etyre.vehicle.model.factory;

import java.util.Set;

import com.etyre.vehicle.model.Vehicle;
import com.etyre.vehicle.model.VehicleFitment;
import com.etyre.vehicle.model.VehicleModel;

/**
 * @author ssd1kor
 *
 */
public class VehicleFactory {

	public static Vehicle createVehicle(String name, String image, VehicleModel vehicleModel, Set<VehicleFitment> fitments){
		
		Vehicle vehicle = new Vehicle(name, image, vehicleModel);
		
		if (null != fitments && !fitments.isEmpty()){
			for (VehicleFitment fitment : fitments){
				vehicle.addFitment(fitment.getTireFitment().getFront(), fitment.getTireFitment().getRear());
			}
		}
		
		return vehicle;
	}
}
