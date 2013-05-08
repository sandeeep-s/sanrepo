package com.etyre.vehicle.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 09-Oct-2012 5:08:18 PM
 */
@Entity
@Table(name = "vehicle_fitment")
public class VehicleFitment implements Serializable {

	private Long id;

	private int version;

	private TireFitment tireFitment;

	public VehicleFitment() {

	}

	public VehicleFitment(TireFitment tireFitment) {
		this.tireFitment = tireFitment;
	}

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

	private void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Unidirectional one-to-one mapping to TireFitment objects using foreign key
	 * Cascading all the operations on VehicleFitment to TireFitment as they have one to one mapping. 
	 * Lifecycle of Tirefitment is dependent on VehicleFitment
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "tire_fitment_id", nullable = false)
	public TireFitment getTireFitment() {
		return tireFitment;
	}

	private void setTireFitment(TireFitment tireFitment) {
		this.tireFitment = tireFitment;
	}

	public boolean equals(Object other) {
		if (!(other instanceof VehicleFitment)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleFitment that = (VehicleFitment) other;
		return this.tireFitment.equals(that.getTireFitment());
	}

	public int hashCode() {
		return tireFitment.hashCode();
	}
}//end Fitment