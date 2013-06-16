package com.eshop.vehicle.form;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.common.model.Media;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleType;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleModelForm implements Serializable {

	private Long id;

	private Integer version;

	private String name;

	private Integer modelYear;

	private List<Media> images;

	private VehicleType vehicleType;

	private VehicleMake vehicleMake;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer manufacturingYear) {
		this.modelYear = manufacturingYear;
	}

	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(VehicleMake vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof VehicleModelForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleModelForm that = (VehicleModelForm) other;
		return this.name.equals(that.getName()) && this.modelYear.equals(that.getModelYear());

	}

	@Override
	public int hashCode() {
		return name.hashCode() + modelYear.hashCode();
	}

}// end VehicleModel