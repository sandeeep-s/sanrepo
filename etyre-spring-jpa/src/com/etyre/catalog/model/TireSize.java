package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This class represents size of a tire. It is a value type as it is owned by Tire
 * class. It does not support shared references. Hence association with product is
 * realized through constructor at creation time itself. Also it is made immutable
 * by marking all setters as private. It is also annotated as Immutable. This
 * helps hibernate to make some performance optimizations.  Tire size is branded
 * on the sidewall of the tyre. It provides significant amount of information
 * about the tire Size Format : <Service Type><Section Width>/<Aspect Ratio><Speed
 * Rating><Internal Construction><Run Flat> <Service Description> Sample Size
 * Format : P225/50ZRF16 91S
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:24 PM
 */
@Embeddable
@org.hibernate.annotations.Immutable
public class TireSize implements Serializable {

	/**
	 * Identifies the type of vehicle or service for which tire was designed
	 * Sample Values : P, T, LT, C, ST etc.
	 */
	private String serviceType;

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
	 * Identifies speed rating fro the tire. 
	 * Sample value :P, Q, R,  S, Z etc..
	 */

	private String speedRating;
	/**
	 * Indicates the Internal construction of the tire. 
	 * Sample values : R, D, B
	 */
	private String internalConstruction;

	/**
	 * Identifies tires with self-supporting run-flat construction
	 * 
	 */
	private String runFlat;

	/**
	 * Tire and wheel diameter in inches Sample value : 16, 17, 18, 17.5, 16.5
	 */
	private String diameter;

	/**
	 * Service description identifies tires load index and speed rating. 
	 * Sample value : 87S. 87 is load index and S is speed rating
	 */
	private String serviceDescription;

	/**
	 * Identifies load carrying capability of the tire.
	 * Sample Values: 87, 91
	 */
	private String loadIndex;

	/**Marked as private as client should always use the other constructor
	 * Hibernate needs this default constructor.
	 * 
	 */
	private TireSize() {

	}

	/**
	 * Constructor to create object with all values.
	 * Tire object is also passed to realize the association at the construction time itself as TireSize object does not support shared references
	 * @param tire
	 * @param serviceType
	 * @param sectionWidth
	 * @param aspectRatio
	 * @param speedRating
	 * @param internalConstruction
	 * @param runFlat
	 * @param diameter
	 * @param serviceDescription
	 */
	TireSize(Tire tire, String serviceType, String sectionWidth, String aspectRatio, String speedRating, String internalConstruction,
			String runFlat, String diameter, String serviceDescription) {
		this.serviceType = serviceType;
		this.sectionWidth = sectionWidth;
		this.aspectRatio = aspectRatio;
		this.speedRating = speedRating;
		this.internalConstruction = internalConstruction;
		this.runFlat = runFlat;
		this.diameter = diameter;
		this.serviceDescription = serviceDescription;

		tire.setSize(this);
	}

	@Column(nullable = false, length = 10)
	public String getServiceType() {
		return serviceType;
	}

	@Column(nullable = false)
	private void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(nullable = false, length = 10)
	public String getSectionWidth() {
		return sectionWidth;
	}

	private void setSectionWidth(String sectionWidth) {
		this.sectionWidth = sectionWidth;
	}

	@Column(nullable = false, length = 10)
	public String getAspectRatio() {
		return aspectRatio;
	}

	private void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	@Column(nullable = false, length = 10)
	public String getSpeedRating() {
		return speedRating;
	}

	private void setSpeedRating(String speedRating) {
		this.speedRating = speedRating;
	}

	@Column(nullable = false, length = 10)
	public String getInternalConstruction() {
		return internalConstruction;
	}

	private void setInternalConstruction(String internalConstruction) {
		this.internalConstruction = internalConstruction;
	}

	@Column(length = 10)
	public String getRunFlat() {
		return runFlat;
	}

	private void setRunFlat(String runFlat) {
		this.runFlat = runFlat;
	}

	@Column(nullable = false, length = 10)
	public String getDiameter() {
		return diameter;
	}

	private void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	@Column(nullable = false, length = 10)
	public String getServiceDescription() {
		return serviceDescription;
	}

	private void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Column(nullable = false, length = 10)
	public String getLoadIndex() {
		return loadIndex;
	}

	private void setLoadIndex(String loadIndex) {
		this.loadIndex = loadIndex;
	}

	public boolean equals(Object other) {
		if (!(other instanceof TireSize)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final TireSize that = (TireSize) other;
		return this.serviceType.equals(that.getServiceType()) && this.sectionWidth.equals(that.getSectionWidth())
				&& this.aspectRatio.equals(that.getAspectRatio()) && this.speedRating.equals(that.getSpeedRating())
				&& this.internalConstruction.equals(that.getInternalConstruction()) && this.runFlat.equals(that.getRunFlat())
				&& this.diameter.equals(that.getDiameter()) && this.serviceDescription.equals(that.getServiceDescription())
				&& this.loadIndex.equals(that.getLoadIndex());
	}

	public int hashCode() {
		return serviceType.hashCode() + sectionWidth.hashCode() + aspectRatio.hashCode() + speedRating.hashCode()
				+ internalConstruction.hashCode() + runFlat.hashCode() + diameter.hashCode() + serviceDescription.hashCode()
				+ loadIndex.hashCode();
	}
}// end TireSize