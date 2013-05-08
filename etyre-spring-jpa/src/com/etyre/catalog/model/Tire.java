package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Tire is created as a subclass as it has additional attributes than a normal
 * product. Tire size and pattern are unique for tires
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:24 PM
 */
@Entity
public class Tire extends Product implements Serializable{

	/**
	 * Defines a particular tire model from a brand. 
	 */
	private TirePattern pattern;

	private TireSize size;

	public Tire() {

	}
	
	public Tire(Brand brand, String name, String description, TirePattern pattern) {
		super(brand, name, description);
		this.pattern = pattern;
	}

	@ManyToOne@JoinColumn(name = "pattern_id", nullable = false)
	public TirePattern getPattern() {
		return pattern;
	}

	public void setPattern(TirePattern pattern) {
		this.pattern = pattern;
	}

	@Embedded
	public TireSize getSize() {
		return size;
	}

	/**
	 * Made the method package accessible as association with tireSize object is realized in the constructor of TireSize
	 * This is to avoid shared references to the tireSize object.
	 * @param size
	 */
	void setSize(TireSize size) {
		this.size = size;
	}

	/**
	 * Adds size data for the tire 
	 * @param serviceType
	 * @param sectionWidth
	 * @param aspectRatio
	 * @param speedRating
	 * @param internalConstruction
	 * @param runFlat
	 * @param diameter
	 * @param serviceDescription
	 */
	public void addTireSize(String serviceType, String sectionWidth, String aspectRatio, String speedRating,
			String internalConstruction, String runFlat, String diameter, String serviceDescription) {
		
		new TireSize(this, serviceType, sectionWidth, aspectRatio, speedRating, internalConstruction, runFlat, diameter,
				serviceDescription);
	}

}//end Tire