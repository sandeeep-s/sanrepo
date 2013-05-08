package com.etyre.vehicle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This is a value type. Hence marked as embeddable
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:35:41 PM
 */
@Embeddable
public class TireFitmentSize implements Serializable{

	/**
	 * Indicates Tire section width in millimeters Sample Value : 255, 275 etc.
	 */
	private String sectionWidth;

	/**
	 * Indicates Tire section height as a percentage of section width.
	 * Also referred to as tire profile, tire series. Sample value: 50, 70
	 */
	private String aspectRatio;

	/**
	 * Tire and wheel diameter in inches Sample value : 16, 17, 18, 17.5, 16.5
	 */
	private String diameter;

	public TireFitmentSize() {

	}

	public TireFitmentSize(String sectionWidth, String aspectratio, String diameter) {
		this.sectionWidth = sectionWidth;
		this.aspectRatio = aspectratio;
		this.diameter = diameter;
	}

	@Column(nullable=false,length=10)
	public String getSectionWidth() {
		return sectionWidth;
	}

	private void setSectionWidth(String sectionWidth) {
		this.sectionWidth = sectionWidth;
	}

	@Column(nullable=false,length=10)
	public String getAspectRatio() {
		return aspectRatio;
	}

	private void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	@Column(nullable=false,length=10)
	public String getDiameter() {
		return diameter;
	}

	private void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public boolean equals(Object other) {
		if (!(other instanceof TireFitmentSize)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final TireFitmentSize that = (TireFitmentSize) other;
		return this.sectionWidth.equals(that.getSectionWidth()) && this.aspectRatio.equals(that.getAspectRatio())
				&& this.diameter.equals(that.getDiameter());
	}

	public int hashCode() {
		return sectionWidth.hashCode() + aspectRatio.hashCode() + diameter.hashCode();
	}
}//end TireFitmentSize