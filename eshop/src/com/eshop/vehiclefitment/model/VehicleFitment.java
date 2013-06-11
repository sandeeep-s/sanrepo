package com.eshop.vehiclefitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleSubModel;

@Entity
@Table(name = "vehicle_fitment")
public class VehicleFitment implements Serializable {

	private Long id;

	private int version;

	private List<FitmentComponent> fitmentComponents;

	private Boolean originalEquipment;

	private VehicleModel vehicleModel;

	private VehicleSubModel vehicleSubModel;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ElementCollection(fetch=FetchType.EAGER)
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

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="vehicle_model_id")
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicle_submodel_id")
	public VehicleSubModel getVehicleSubModel() {
		return vehicleSubModel;
	}

	public void setVehicleSubModel(VehicleSubModel vehicleSubModel) {
		this.vehicleSubModel = vehicleSubModel;
	}

	
}
