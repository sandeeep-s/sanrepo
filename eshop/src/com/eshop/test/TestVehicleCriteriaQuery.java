package com.eshop.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.common.model.Media;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehiclefitment.model.VehicleFitment;

public class TestVehicleCriteriaQuery extends GenericDAOImpl<VehicleMake, Long> {

	public List<Integer> getModelYearsForMake(Long vehicleMakeId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root vehicleModel = cq.from(VehicleModel.class);
		cq.select(vehicleModel.get("modelYear")).distinct(true);
		cq.where(cb.equal(vehicleModel.get("vehicleMake").get("id"), cb.parameter(Long.class, "vehicleMakeId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("vehicleMakeId", vehicleMakeId);

		List<Integer> modelYearList = query.getResultList();

		return modelYearList;
	}

	public List<VehicleModel> getVehicleModelForMakeAndYear(Long vehicleMakeId, Integer modelYear) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<VehicleModel> cq = cb.createQuery(VehicleModel.class);
		Root<VehicleModel> vehicleModel = cq.from(VehicleModel.class);
		cq.select(vehicleModel);
		Predicate vehicleMakeCondition = cb.equal(vehicleModel.get("vehicleMake").get("id"), cb.parameter(Long.class, "vehicleMakeId"));
		Predicate modelYearCondition = cb.equal(vehicleModel.get("modelYear"), cb.parameter(Integer.class, "modelYear"));
		cq.where(cb.and(vehicleMakeCondition, modelYearCondition));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("vehicleMakeId", vehicleMakeId);
		query.setParameter("modelYear", modelYear);

		List<VehicleModel> vehicleModels = query.getResultList();

		return vehicleModels;
	}

	public List<VehicleSubModel> getVehicleSubModelsForVehicleModel(Long vehicleModelId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<VehicleSubModel> cq = cb.createQuery(VehicleSubModel.class);
		Root<VehicleSubModel> vehicleSubModel = cq.from(VehicleSubModel.class);
		cq.select(vehicleSubModel);
		cq.where(cb.equal(vehicleSubModel.get("vehicleModel").get("id"), cb.parameter(Long.class, "vehicleModelId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("vehicleModelId", vehicleModelId);

		List<VehicleSubModel> vehicleSubModels = query.getResultList();

		return vehicleSubModels;

	}

	public List<VehicleSubModel> getInitializedVehicleSubModel(Long vehicleModelId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<VehicleSubModel> cq = cb.createQuery(VehicleSubModel.class);
		Root<VehicleSubModel> vehicleSubModel = cq.from(VehicleSubModel.class);
		Fetch<VehicleSubModel, Media> images = vehicleSubModel.fetch("images");
		cq.select(vehicleSubModel);
		cq.where(cb.equal(vehicleSubModel.get("vehicleModel").get("id"), cb.parameter(Long.class, "vehicleModelId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("vehicleModelId", vehicleModelId);

		List<VehicleSubModel> vehicleSubModels = query.getResultList();

		return vehicleSubModels;

	}

	public List<VehicleFitment> findAllVehicleFitmentsForVehicleModel(Long vehicleModelId) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<VehicleFitment> cq = cb.createQuery(VehicleFitment.class);
		Root<VehicleFitment> vehicleFitment = cq.from(VehicleFitment.class);
		Fetch<VehicleFitment, VehicleModel> vehicleModel = vehicleFitment.fetch("vehicleModel");
		cq.select(vehicleFitment);
		cq.where(cb.equal(vehicleFitment.get("vehicleModel").get("id"), cb.parameter(Long.class, "vehicleModelId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("vehicleModelId", vehicleModelId);

		List<VehicleFitment> vehicleFitments = query.getResultList();

		return vehicleFitments;
	}

}