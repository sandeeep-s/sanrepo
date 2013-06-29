package com.eshop.vehiclefitment.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.eshop.base.model.EntityBase;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehiclefitment.model.FitmentComponent;

@Entity
@Table(name = "vehicle_fitment")
public class VehicleFitment extends EntityBase {

	private List<FitmentComponent> fitmentComponents;

	private Boolean originalEquipment;

	private VehicleModel vehicleModel;

	private VehicleSubModel vehicleSubModel;

	public VehicleFitment() {

	}

	public VehicleFitment(VehicleModel vehicleModel, VehicleSubModel vehicleSubModel, List<FitmentComponent> fitmentComponents,
			Boolean originalEquipment) {
		this.vehicleModel = vehicleModel;
		this.vehicleSubModel = vehicleSubModel;
		this.fitmentComponents = fitmentComponents;
		this.originalEquipment = originalEquipment;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "fitment_component", joinColumns = @JoinColumn(name = "fitment_id"))
	public List<FitmentComponent> getFitmentComponents() {
		return fitmentComponents;
	}

	public void setFitmentComponents(List<FitmentComponent> fitmentComponents) {
		this.fitmentComponents = fitmentComponents;
	}

	@Column(nullable = false)
	public Boolean getOriginalEquipment() {
		return originalEquipment;
	}

	public void setOriginalEquipment(Boolean originalEquipment) {
		this.originalEquipment = originalEquipment;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_model_id")
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	private void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_submodel_id")
	public VehicleSubModel getVehicleSubModel() {
		return vehicleSubModel;
	}

	private void setVehicleSubModel(VehicleSubModel vehicleSubModel) {
		this.vehicleSubModel = vehicleSubModel;
	}

}
