package com.eshop.catalog.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Dimension {

	private DimensionProperty dimensionProperty;

	private String dimensionValue;

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dimension_property_id",nullable = false)
	public DimensionProperty getDimensionProperty() {
		return dimensionProperty;
	}

	public void setDimensionProperty(DimensionProperty dimensionProperty) {
		this.dimensionProperty = dimensionProperty;
	}

	@Column(nullable = false, length = 250)
	public String getDimensionValue() {
		return dimensionValue;
	}

	public void setDimensionValue(String dimensionValue) {
		this.dimensionValue = dimensionValue;
	}

}
