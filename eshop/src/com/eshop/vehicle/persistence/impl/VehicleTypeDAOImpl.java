/**
 * 
 */
package com.eshop.vehicle.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.persistence.VehicleTypeDAO;

/**
 * @author ssd1kor
 *
 */
@Repository("vehicleTypeDAO")
public class VehicleTypeDAOImpl extends GenericDAOImpl<VehicleType, Long> implements VehicleTypeDAO{
	
	public VehicleTypeDAOImpl(){
		super(VehicleType.class);
	}

}
