package com.eshop.vehicle.model;

import java.io.Serializable;
import java.util.Set;

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

import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(name = "vehicle_submodel")
public class VehicleSubModel implements Serializable {

	private Long id;

	private int version;

	private VehicleModel vehicleModel;

	private String name;

	private Set<Media> images;


	public VehicleSubModel() {

	}

	public VehicleSubModel(String name, Set<Media> images, VehicleModel vehicleModel) {
		this.name = name;
		this.images = images;
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
	@ManyToOne(fetch = FetchType.EAGER)
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

	@ElementCollection
	@CollectionTable(name = "Vehicle_Submodel_Media", joinColumns = @JoinColumn(name = "Vehicle_Id"))
	public Set<Media> getImages() {
		return images;
	}

	public void setImages(Set<Media> images) {
		this.images = images;
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
		if (!(other instanceof VehicleSubModel)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleSubModel that = (VehicleSubModel) other;
		return this.name.equals(that.getName()) && this.vehicleModel.equals(that.getVehicleModel());
	}

	public int hashCode() {
		return name.hashCode() + vehicleModel.hashCode();
	}
}//end Vehicle