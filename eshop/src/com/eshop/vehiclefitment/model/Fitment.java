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

@Entity
@Table(name = "fitment")
public class Fitment implements Serializable{

	private Long id;

	private int version;

	private List<FitmentComponent> fitmentComponents = new ArrayList<FitmentComponent>();

	private Boolean originalEquipment;

	private VehicleFitment vehicleFitment;

	@Id()
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

	@ElementCollection
	@CollectionTable(name = "fitment_component", joinColumns = @JoinColumn(name = "fitment_id"))
	public List<FitmentComponent> getFitmentComponents() {
		return fitmentComponents;
	}

	public void setFitmentComponents(List<FitmentComponent> fitmentComponents) {
		this.fitmentComponents = fitmentComponents;
	}

	@Column(nullable=false)
	public Boolean getOriginalEquipment() {
		return originalEquipment;
	}

	public void setOriginalEquipment(Boolean originalEquipment) {
		this.originalEquipment = originalEquipment;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "vehicle_fitment_id", nullable = false)
	public VehicleFitment getVehicleFitment() {
		return vehicleFitment;
	}

	public void setVehicleFitment(VehicleFitment vehicleFitment) {
		this.vehicleFitment = vehicleFitment;
	}

}