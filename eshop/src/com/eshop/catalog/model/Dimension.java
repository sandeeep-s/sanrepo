package com.eshop.catalog.model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Dimension {

	private DimensionProperty dimensionProperty;

	private String dimensionValue;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dimension_property_id")
	public DimensionProperty getDimensionProperty() {
		return dimensionProperty;
	}

	public void setDimensionProperty(DimensionProperty dimensionProperty) {
		this.dimensionProperty = dimensionProperty;
	}

	public String getDimensionValue() {
		return dimensionValue;
	}

	public void setDimensionValue(String dimensionValue) {
		this.dimensionValue = dimensionValue;
	}

}
