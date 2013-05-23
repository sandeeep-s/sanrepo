/**
 * 
 */
package com.eshop.vehiclefitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleSubModel;

/**
 * @author ssd1kor
 *
 */

@Entity
@Table(name = "vehicle_fitment")
public class VehicleFitment implements Serializable {

	private Long id;

	private int version;

	private List<Fitment> fitments = new ArrayList<Fitment>();

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

	@OneToMany(mappedBy = "vehicleFitment", cascade=CascadeType.PERSIST)
	public List<Fitment> getFitments() {
		return fitments;
	}

	public void setFitments(List<Fitment> fitments) {
		this.fitments = fitments;
	}

	@ManyToOne
	@JoinColumn(name = "vehicle_model_id")
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@ManyToOne
	@JoinColumn(name = "vehicle_submodel_id")
	public VehicleSubModel getVehicleSubModel() {
		return vehicleSubModel;
	}

	public void setVehicleSubModel(VehicleSubModel vehicleSubModel) {
		this.vehicleSubModel = vehicleSubModel;
	}

	public void addFitment(Fitment fitment) {
		fitment.setVehicleFitment(this);
		this.fitments.add(fitment);
	}

}
