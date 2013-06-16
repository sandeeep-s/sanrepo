package com.eshop.vehicle.model;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.model.EntityBase;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(name = "vehicle_submodel")
public class VehicleSubModel extends EntityBase {

	private VehicleModel vehicleModel;

	private String name;

	private List<Media> images;

	public VehicleSubModel() {

	}

	public VehicleSubModel(VehicleModel vehicleModel, String name, List<Media> images) {
		this.vehicleModel = vehicleModel;
		this.name = name;
		this.images = images;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_model_id", nullable = false)
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	private void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@NotBlank
	@Column(nullable = false, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@ElementCollection
	@CollectionTable(name = "vehicle_submodel_media", joinColumns = @JoinColumn(name = "vehicle_submodel_id"))
	@OrderColumn(name = "sort_order")
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
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

	@Override
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

	@Override
	public int hashCode() {
		return name.hashCode() + vehicleModel.hashCode();
	}
}//end Vehicle