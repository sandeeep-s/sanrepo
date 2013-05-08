package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * This class represents dimensions of a product. It is a value type as it is
 * owned by Product class. It does not support shared references. Hence
 * association with product is realized through constructor at creation time
 * itself. Also it is made immutable by marking all setters as private. It is also
 * annotated as Immutable. This helps hibernate to make some performance
 * optimizations.
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:23 PM
 */
@Embeddable@org.hibernate.annotations.Immutable
public class Dimensions implements Serializable{

	private String length;

	private String lengthUnit;

	private String width;

	private String widthUnit;

	private String height;

	private String heightUnit;

	private String volume;

	private String volumeUnit;

	private String weight;

	private String weightUnit;

	/**Marked as private as client should always use the other constructor
	 * Hibernate needs this default constructor.
	 * 
	 */
	private Dimensions() {

	}

	/**
	 * Constructor to create object with all values.
	 * Product object is also passed to realize the association at the construction time itself as Dimensions object does not support shared references
	 * @param product
	 * @param length
	 * @param lengthUnit
	 * @param width
	 * @param widthUnit
	 * @param height
	 * @param heightUnit
	 * @param volume
	 * @param volumeUnit
	 * @param weight
	 * @param weightUnit
	 */
	public Dimensions(Product product, String length, String lengthUnit, String width, String widthUnit, String height, String heightUnit,
			String volume, String volumeUnit, String weight, String weightUnit) {

		this.length = length;
		this.lengthUnit = lengthUnit;
		this.width = width;
		this.widthUnit = weightUnit;
		this.height = height;
		this.heightUnit = heightUnit;
		this.volume = volume;
		this.volumeUnit = volumeUnit;
		this.weight = weight;
		this.weightUnit = weightUnit;

		/*Realize the association with product*/
		product.setDimensions(this);
	}

	public String getLength() {
		return length;
	}

	private void setLength(String length) {
		this.length = length;
	}

	public String getLengthUnit() {
		return lengthUnit;
	}

	private void setLengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}

	public String getWidth() {
		return width;
	}

	private void setWidth(String width) {
		this.width = width;
	}

	public String getWidthUnit() {
		return widthUnit;
	}

	private void setWidthUnit(String widthUnit) {
		this.widthUnit = widthUnit;
	}

	public String getHeight() {
		return height;
	}

	private void setHeight(String height) {
		this.height = height;
	}

	public String getHeightUnit() {
		return heightUnit;
	}

	private void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}

	public String getVolume() {
		return volume;
	}

	private void setVolume(String volume) {
		this.volume = volume;
	}

	public String getVolumeUnit() {
		return volumeUnit;
	}

	private void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	public String getWeight() {
		return weight;
	}

	private void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	private void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	/**
	 * Overriding equals and hashcode is recommended for value types. Hibernate relies on this method to check instances for modifications
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Dimensions)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Dimensions that = (Dimensions) other;
		return this.length.equals(that.length) && this.lengthUnit.equals(that.lengthUnit) && this.width.equals(that.width)
				&& this.widthUnit.equals(that.widthUnit) && this.height.equals(that.height) && this.heightUnit.equals(that.heightUnit)
				&& this.volume.equals(that.volume) && this.volumeUnit.equals(that.volumeUnit) && this.weight.equals(that.weight)
				&& this.weightUnit.equals(that.weightUnit);
	}

	public int hashCode() {
		return length.hashCode() + lengthUnit.hashCode() + width.hashCode() + widthUnit.hashCode() + height.hashCode()
				+ heightUnit.hashCode() + volume.hashCode() + volumeUnit.hashCode() + weight.hashCode() + weightUnit.hashCode();
	}

}//end Dimensions