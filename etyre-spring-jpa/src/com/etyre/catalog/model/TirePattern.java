package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.etyre.vehicle.model.VehicleType;

/**
 * This class defines a particular tire pattern or model from a particular brand.
 * This pattern can have multiple sizes. Each size will represent a tire.
 * @author ssd1kor
 * @version 1.0
 * @updated 10-Oct-2012 5:52:03 PM
 */
@Entity
@Table(name = "tire_pattern", uniqueConstraints = @UniqueConstraint(name = "pat_brand_name_uniq", columnNames = { "name", "brand_id" }))
public class TirePattern implements Serializable {

	private Long id;

	private int version;

	private VehicleType vehicleType;

	private Brand brand;

	private String name;

	private String description;

	private String warranty;

	private String importantNotes;

	private String image;

	public TirePattern() {

	}

	/**
	 * Constructor with non-nullable properties as arguments
	 * @param brand
	 * @param name
	 * @param description
	 * @param image
	 */
	public TirePattern(Brand brand, String name, String description, String image) {
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.image = image;
	}

	/**
	 * Consructor with all properties as arguments
	 * @param brand
	 * @param name
	 * @param description
	 * @param image
	 * @param warranty
	 * @param importantNotes
	 * @param vehicleType
	 */
	public TirePattern(Brand brand, String name, String description, String image, String warranty, String importantNotes,
			VehicleType vehicleType) {
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.image = image;
		this.warranty = warranty;
		this.importantNotes = importantNotes;
		this.vehicleType = vehicleType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@ManyToOne
	@JoinColumn(name = "vehicleType_id")
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getImportantNotes() {
		return importantNotes;
	}

	public void setImportantNotes(String importantNotes) {
		this.importantNotes = importantNotes;
	}

	@Column(nullable = false)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean equals(Object other) {
		if (!(other instanceof TirePattern)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final TirePattern that = (TirePattern) other;
		return this.name.equals(that.getName()) && this.brand.equals(that.getBrand());
	}

	public int hashCode() {
		return name.hashCode() + brand.hashCode();
	}

}//end Pattern