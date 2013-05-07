/**
 * 
 */
package com.etyre.vehicle.persistence.impl;

import org.springframework.stereotype.Repository;

import com.etyre.base.persistence.impl.GenericDAOImpl;
import com.etyre.vehicle.model.VehicleMake;
import com.etyre.vehicle.persistence.VehicleMakeDAO;

/**
 * @author ssd1kor
 * 
 */
@Repository("vehicleMakeDAO")
public class VehicleMakeDAOImpl extends GenericDAOImpl<VehicleMake, Long> implements VehicleMakeDAO {

    public VehicleMakeDAOImpl()
    {
        super(VehicleMake.class);
    }

}
