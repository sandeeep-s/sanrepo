package com.eshop.vehicle.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eshop.vehicle.service.VehicleReferenceDataService;

@Service("vehicleReferenceDataService")
public class VehicleReferenceDataServiceImpl implements VehicleReferenceDataService {

	@Resource(name = "modelYearsReferenceList")
	private List<Integer> modelYearsReferenceList;

	public List<Integer> getModelYearsReferenceList() {
		return modelYearsReferenceList;
	}

	public void setModelYearsReferenceList(List<Integer> modelYearsReferenceList) {
		this.modelYearsReferenceList = modelYearsReferenceList;
	}

}
