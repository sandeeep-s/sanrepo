package com.eshop.vehicle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(name = "vehicle_model")
public class VehicleModel implements Serializable {

	private Long id;

	private int version;

	private String name;

	private Integer modelYear;

	private List<Media> images;

	private VehicleType vehicleType;

	private VehicleMake vehicleMake;

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

	@NotEmpty
	@Column(unique = true, nullable = false, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(nullable = false)
	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer manufacturingYear) {
		this.modelYear = manufacturingYear;
	}

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "vehicle_model_media", joinColumns = @JoinColumn(name = "vehicle_model_id"))
	@OrderColumn(name="sort_order")
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_type_id", nullable = false)
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_make_id", nullable = false)
	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(VehicleMake vehicleMake) {
		this.vehicleMake = vehicleMake;
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
		if (!(other instanceof VehicleModel)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleModel that = (VehicleModel) other;
		return this.name.equals(that.getName()) && this.modelYear.equals(that.getModelYear());

	}

	public int hashCode() {
		return name.hashCode() + modelYear.hashCode();
	}

}// end VehicleModel