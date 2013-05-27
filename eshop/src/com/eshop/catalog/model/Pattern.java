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
 * @author ssd1kor
 * @version 1.0
 * @updated 10-Oct-2012 5:52:03 PM
 */
@Entity
@Table(name = "pattern")
public class Pattern implements Serializable {

	private Long id;

	private int version;

	private String name;

	private String description;

	private String warranty;

	private String importantNotes;

	private Brand brand;

	private List<Media> images;

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

	@Column(nullable = false, unique = true, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 750)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 750)
	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Column(length = 750)
	public String getImportantNotes() {
		return importantNotes;
	}

	public void setImportantNotes(String importantNotes) {
		this.importantNotes = importantNotes;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brand_id", nullable = false)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ElementCollection
	@CollectionTable(name = "pattern_media", joinColumns = @JoinColumn(name = "pattern_id"))
	public List<Media> getImages() {
		return images;
	}

	public void setImages(List<Media> images) {
		this.images = images;
	}

	/**
	 * If this object is used as detached object, it can be outside guaranteed scope identity of persistence context.
	 * In this case there can be two different objects representing the same row in database. They will have same database identity 
	 * but different java identity. 
	 * Hence override equals and hashcode method as default check only java identity.
	 * 
	 * Use a business key comparison in the equals method. Business key characteristics are uniqueness, non-nullability and rare change.
	 * 
	 * Using id comparison in equals is strongly discouraged as id is assigned by Hibernate only after persistence. This can result in 
	 * changed hash value after object is added to a SET(Collection). This breaks SET contract.
	 * 
	 * Always use getters to compare properties of other object. This is to make sure the code works even if proxies are passed instead
	 * of real objects.
	 */
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

	public String toString() {
		return name;
	}

}//end Pattern