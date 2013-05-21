package com.eshop.catalog.model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TechSpec {

	private TechSpecProperty techSpecProperty;

	private String techSpecValue;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tech_spec_property_id")
	public TechSpecProperty getTechSpecProperty() {
		return techSpecProperty;
	}

	public void setTechSpecProperty(TechSpecProperty techSpecProperty) {
		this.techSpecProperty = techSpecProperty;
	}

	public String getTechSpecValue() {
		return techSpecValue;
	}

	public void setTechSpecValue(String techSpecValue) {
		this.techSpecValue = techSpecValue;
	}

}
