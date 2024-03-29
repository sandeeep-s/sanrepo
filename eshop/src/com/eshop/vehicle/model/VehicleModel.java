package com.eshop.vehicle.model;

import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.base.model.EntityBase;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(name = "vehicle_model")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VehicleModel extends EntityBase {

	private String name;

	private Integer modelYear;

	private List<Media> images;

	private VehicleType vehicleType;

	private VehicleMake vehicleMake;

	public VehicleModel() {

	}

	public VehicleModel(String name, Integer modelYear, List<Media> images, VehicleType vehicleType, VehicleMake vehicleMake) {
		this.name = name;
		this.modelYear = modelYear;
		this.images = images;
		this.vehicleType = vehicleType;
		this.vehicleMake = vehicleMake;
	}

	@NotBlank
	@Column(unique = true, nullable = false, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Min(1950)
	@Max(2050)
	@Column(nullable = false)
	public Integer getModelYear() {
		return modelYear;
	}

	private void setModelYear(Integer manufacturingYear) {
		this.modelYear = manufacturingYear;
	}

	@NotEmpty
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "vehicle_model_media", joinColumns = @JoinColumn(name = "vehicle_model_id"))
	@OrderColumn(name = "sort_order")
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
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_type_id", nullable = false)
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	private void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_make_id", nullable = false)
	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	private void setVehicleMake(VehicleMake vehicleMake) {
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
	@Override
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

	@Override
	public int hashCode() {
		return name.hashCode() + modelYear.hashCode();
	}

}// end VehicleModel