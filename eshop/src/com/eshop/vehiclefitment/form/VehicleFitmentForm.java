package com.eshop.vehiclefitment.form;

import java.util.List;

import com.eshop.base.form.BaseForm;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehiclefitment.model.FitmentComponent;

public class VehicleFitmentForm extends BaseForm {

	private List<FitmentComponent> fitmentComponents;

	private Boolean originalEquipment;

	private VehicleModel vehicleModel;

	private VehicleSubModel vehicleSubModel;
	
	public VehicleFitmentForm() {

	}

	public VehicleFitmentForm(VehicleModel vehicleModel, VehicleSubModel vehicleSubModel, List<FitmentComponent> fitmentComponents,
			Boolean originalEquipment) {
		this.vehicleModel = vehicleModel;
		this.vehicleSubModel = vehicleSubModel;
		this.fitmentComponents = fitmentComponents;
		this.originalEquipment = originalEquipment;
	}

	public List<FitmentComponent> getFitmentComponents() {
		return fitmentComponents;
	}

	public void setFitmentComponents(List<FitmentComponent> fitmentComponents) {
		this.fitmentComponents = fitmentComponents;
	}

	public Boolean getOriginalEquipment() {
		return originalEquipment;
	}

	public void setOriginalEquipment(Boolean originalEquipment) {
		this.originalEquipment = originalEquipment;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public VehicleSubModel getVehicleSubModel() {
		return vehicleSubModel;
	}

	public void setVehicleSubModel(VehicleSubModel vehicleSubModel) {
		this.vehicleSubModel = vehicleSubModel;
	}

}
