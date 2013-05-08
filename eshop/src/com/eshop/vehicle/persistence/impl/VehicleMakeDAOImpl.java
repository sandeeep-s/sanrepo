/**
 * 
 */
package com.eshop.vehicle.persistence.impl;

import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.persistence.VehicleMakeDAO;

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
