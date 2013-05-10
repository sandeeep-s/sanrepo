package com.eshop.catalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

public class Dimension implements Serializable{

	private Long id;

	private int version;

	private String name;

	private String unit;

	private String description;

	private Category category;

	private Dimension() {

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

	@Column(nullable = false, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 50)
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(nullable = false, length = 4000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Dimension)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Dimension that = (Dimension) other;
		return this.name.equals(that.getName()) && this.category.equals(that.getCategory());
	}

	public int hashCode() {
		return name.hashCode() + category.hashCode();
	}

}//end Dimensions