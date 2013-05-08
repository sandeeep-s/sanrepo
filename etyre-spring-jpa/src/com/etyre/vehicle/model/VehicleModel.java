package com.etyre.vehicle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
@Entity
@Table(name = "vehicle_model", uniqueConstraints = @UniqueConstraint(name = "veh_mod_name_man_uniq", columnNames = { "name",
		"manufacturingYear" }))
public class VehicleModel implements Serializable {

	private Long id;

	private int version;

	private String name;

	private Integer manufacturingYear;

	private String image;

	private VehicleType vehicleType;

	private VehicleMake vehicleMake;

	public VehicleModel() {

	}

	public VehicleModel(String name, Integer manufacturingYear, String image, VehicleType vehicleType, VehicleMake vehicleMake) {
		this.name = name;
		this.vehicleType = vehicleType;
		this.vehicleMake = vehicleMake;
		this.manufacturingYear = manufacturingYear;
		this.image = image;
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

	@Column(nullable = false, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	private void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	@Column(nullable = false, length = 250)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "vehicleType_id", nullable = false)
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	//Vehicle Type should be immutable. Hence private

	private void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "vehicleMake_id", nullable = false)
	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	//Vehicle Make should be immutable. Hence private
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
	public boolean equals(Object other) {
		if (!(other instanceof VehicleModel)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleModel that = (VehicleModel) other;
		return this.name.equals(that.getName()) && this.manufacturingYear.equals(that.getManufacturingYear());

	}

	public int hashCode() {
		return name.hashCode() + manufacturingYear.hashCode();
	}

}// end VehicleModel