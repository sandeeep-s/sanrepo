package com.eshop.productsearch.form;

import com.eshop.vehiclefitment.model.VehiclePosition;

public class TireFitmentComponentForm {

	private VehiclePosition position = VehiclePosition.ALL;

	private String section = "";

	private String aspectRatio = "";

	private String diameter = "";

	public VehiclePosition getPosition() {
		return position;
	}

	public void setPosition(VehiclePosition position) {
		position = (null == position) ? position = VehiclePosition.ALL : position;
		this.position = position;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		section = (null == section) ? "" : section;
		this.section = section;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		aspectRatio = (null == aspectRatio) ? "" : aspectRatio;
		this.aspectRatio = aspectRatio;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		diameter = (null == diameter) ? "" : diameter;
		this.diameter = diameter;
	}

	public boolean equals(Object other) {
		if (null == other || !(other instanceof TireFitmentComponentForm)) {
			return false;
		}

		if (this == other) {
			return true;
		}

		TireFitmentComponentForm that = (TireFitmentComponentForm) other;
		return this.section.equals(that.getSection()) && this.aspectRatio.equals(that.getAspectRatio())
				&& this.diameter.equals(that.getDiameter()) && this.position.equals(that.getPosition());
	}

	public int hashCode() {
		return section.hashCode() + aspectRatio.hashCode() + diameter.hashCode();
	}
	
}
