/**
 * 
 */
package com.eshop.vehicle.persistence.impl;

import java.util.List;

import javax.persistence.Query;

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

	@Override
	public List<Integer> getModelYearsForMake(Long vehicleMakeId) {
		Query q = getEntityManager().createNamedQuery("getModelYearsForMake").setParameter("vehicleMakeId", vehicleMakeId);
		List<Integer> modelYears = (List<Integer>)q.getResultList();
		return modelYears;
	}

	@Override
	public VehicleMake findById(Long id){
		Query q = getEntityManager().createQuery("select vehicleMake from VehicleMake vehicleMake where vehicleMake.id = :vehicleMakeId");
		q.setParameter("vehicleMakeId", id);
		q.setMaxResults(1);
		q.setHint("org.hibernate.cacheable", true);
		VehicleMake vehicleMake = (VehicleMake)q.getSingleResult();
		return vehicleMake;
	}

	public VehicleMake updateVehicleMake(VehicleMake detachedVehicleMake){
		VehicleMake persistentVehicleMake = findById(detachedVehicleMake.getId());
		persistentVehicleMake.setName(detachedVehicleMake.getName());
		persistentVehicleMake.setLogoImage(detachedVehicleMake.getLogoImage());
		return persistentVehicleMake;
	}
	
}
