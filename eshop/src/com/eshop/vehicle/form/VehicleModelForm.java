package com.eshop.vehicle.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.eshop.base.form.BaseForm;
import com.eshop.common.model.Media;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleType;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleModelForm extends BaseForm {

	private String name;

	private Integer modelYear;

	private List<Media> images;

	private VehicleType vehicleType;

	private VehicleMake vehicleMake;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Min(1950)
	@Max(2050)
	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer manufacturingYear) {
		this.modelYear = manufacturingYear;
	}

	@NotEmpty
	@Valid
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	@NotNull
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@NotNull
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