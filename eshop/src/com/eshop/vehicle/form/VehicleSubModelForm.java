package com.eshop.vehicle.form;

import java.util.List;
import org.hibernate.validator.constraints.NotBlank;

import com.eshop.base.form.BaseForm;
import com.eshop.common.model.Media;
import com.eshop.vehicle.model.VehicleModel;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 26-Sep-2012 6:40:55 PM
 */
public class VehicleSubModelForm extends BaseForm {

	private VehicleModel vehicleModel;

	private String name;

	private List<Media> images;

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof VehicleSubModelForm)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final VehicleSubModelForm that = (VehicleSubModelForm) other;
		return this.name.equals(that.getName()) && this.vehicleModel.equals(that.getVehicleModel());
	}

	@Override
	public int hashCode() {
		return name.hashCode() + vehicleModel.hashCode();
	}
}//end Vehicle