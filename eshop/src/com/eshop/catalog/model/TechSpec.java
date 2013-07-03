package com.eshop.catalog.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class TechSpec {

	private TechSpecProperty techSpecProperty;

	private String techSpecValue;

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tech_spec_property_id", nullable = false)
	public TechSpecProperty getTechSpecProperty() {
		return techSpecProperty;
	}

	public void setTechSpecProperty(TechSpecProperty techSpecProperty) {
		this.techSpecProperty = techSpecProperty;
	}

	@NotBlank
	@Column(nullable = false, length = 250)
	public String getTechSpecValue() {
		return techSpecValue;
	}

	public void setTechSpecValue(String techSpecValue) {
		this.techSpecValue = techSpecValue;
	}

}
