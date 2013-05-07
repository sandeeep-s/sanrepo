/**
 * 
 */
package com.etyre.vehicle.persistence.impl;

import org.springframework.stereotype.Repository;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.VehicleType;
import com.etyre.vehicle.persistence.VehicleTypeDAO;

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
