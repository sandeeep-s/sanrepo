package com.eshop.catalog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.eshop.common.model.Media;

/**
 * This class defines a particular tire pattern or model from a particular brand.
 * This pattern can have multiple sizes. Each size will represent a tire.
 * @author ssd1kor
 * @version 1.0
 * @updated 10-Oct-2012 5:52:03 PM
 */
@Entity
@Table(name = "pattern")
public class Pattern implements Serializable {

	private Long id;

	private int version;

	private Brand brand;

	private String name;

	private String description;

	private String warranty;

	private String importantNotes;

	private List<Media> images = new ArrayList<Media>();

	public Pattern() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name = "brand_id")
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

	public void setName(String name) {
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

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "pattern_image", joinColumns = @JoinColumn(name = "pattern_id"))
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Pattern)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Pattern that = (Pattern) other;
		return this.name.equals(that.getName()) && this.brand.equals(that.getBrand());
	}

	public int hashCode() {
		return name.hashCode() + brand.hashCode();
	}

	public String toString(){
		return name;
	}
	
}//end Pattern