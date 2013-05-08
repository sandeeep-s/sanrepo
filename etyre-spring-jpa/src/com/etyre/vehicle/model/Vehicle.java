package com.etyre.vehicle.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "veh_name_mod_uniq", columnNames = { "name", "vehicle_model_id" }))
public class Vehicle implements Serializable {

	private Long id;

	private int version;

	private VehicleModel vehicleModel;

	private String name;

	private String image;

	private Set<VehicleFitment> fitments = new HashSet<VehicleFitment>();

	public Vehicle() {

	}

	public Vehicle(String name, String image, VehicleModel vehicleModel) {
		this.name = name;
		this.image = image;
		this.vehicleModel = vehicleModel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
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
	 * The FetchType.EAGER will load the association eagerly. A single join query will be used to load both Vehicle and VehicleModel objects
	 * It is marked as eager because initialized VehicleModel object is always required with the Vehicle object. FetchType.EAGER provides the guarantee
	 * that VehicleModel will always be initialized while querying for Vehicle.
	 * FetchType.EAGER is the default for ManyToOne association.
	 * @return
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "vehicle_model_id", nullable = false)
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@Column(nullable = false, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 250)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Cascading all the operations on Vehicle objects to the fitments collection as each fitment is attached to a single Vehicle
	 * The FetchType.LAZY tells the persistence provider to load the association lazily. VehicleFitment objects are not initialized when Vehicle is loaded.
	 * Only when the collection is iterated will the VehicleFitment objects initialized.
	 * @return
	 */
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	public Set<VehicleFitment> getFitments() {
		return fitments;
	}

	private void setFitments(Set<VehicleFitment> fitments) {
		this.fitments = fitments;
	}

	public void addFitment(TireFitmentSize front, TireFitmentSize rear) {
		TireFitment tireFitment = new TireFitment(front, rear);
		VehicleFitment fitment = new VehicleFitment(tireFitment);
		fitments.add(fitment);
	}

	/**
	 * If this object is used as detached object, it can be outside guaranteed scope identity of persistence context.
	 * In this case there can be two different objects representing the same row in database. They will have same database identity 
	 * but different java identity. 
	 * Hence override equals and hashcode method as default check only java identity.
	 * 
	 * Use a business key comparison in the equals method. Business key characteristics are uniqueness, non-nullability and rare change.
	 * 
	 * Using id comparison in equals is strongly discouraged as id is assigned by Hibernate only after persistence. This can result in 
	 * changed hash value after object is added to a SET(Collection). This breaks SET contract.
	 * 
	 * Always use getters to compare properties of other object. This is to make sure the code works even if proxies are passed instead
	 * of real objects.
	 */

	public boolean equals(Object other) {
		if (!(other instanceof Vehicle)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Vehicle that = (Vehicle) other;
		return this.name.equals(that.getName()) && this.vehicleModel.equals(that.getVehicleModel());
	}

	public int hashCode() {
		return name.hashCode() + vehicleModel.hashCode();
	}
}//end Vehicle