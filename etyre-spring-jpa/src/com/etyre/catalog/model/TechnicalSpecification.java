package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This class represents technical specification of a product. It is a value type
 * as it is owned by Product class. It does not support shared references. Hence
 * association with product is realized through constructor at creation time
 * itself. Also it is made immutable by marking all setters as private. It is also
 * annotated as Immutable. This helps hibernate to make some performance
 * optimizations.
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:24 PM
 */
@Embeddable
@org.hibernate.annotations.Immutable
public class TechnicalSpecification implements Serializable {

	private TechSpecDefinition techSpecDefinition;

	private String value;

	/**Marked as private as client should always use the other constructor
	 * Hibernate needs this default constructor.
	 * 
	 */
	private TechnicalSpecification() {

	}

	/**
	 * Constructor to create object with all values.
	 * Product object is also passed to realize the association at the construction time itself as TechnicalSpecification object does not support shared references
	 * @param product
	 * @param value
	 * @param unit
	 * @param techSpecDefinition
	 */
	public TechnicalSpecification(Product product, String value, TechSpecDefinition techSpecDefinition) {
		this.value = value;
		this.techSpecDefinition = techSpecDefinition;

		product.getTechnicalSpecifications().add(this);
	}

	@Column(nullable = false)
	public String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}

	@ManyToOne
	@JoinColumn(name = "techSpecDefinition_Id", nullable = false)
	public TechSpecDefinition getTechSpecDefinition() {
		return techSpecDefinition;
	}

	private void setTechSpecDefinition(TechSpecDefinition techSpecDefinition) {
		this.techSpecDefinition = techSpecDefinition;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof TechnicalSpecification)) {
			return false;
		}
		if (other == this) {
			return true;
		}
		final TechnicalSpecification that = (TechnicalSpecification) other;
		return this.techSpecDefinition.equals(that.getTechSpecDefinition()) && this.value.equals(that.getValue());
	}

	@Override
	public int hashCode() {
		return techSpecDefinition.hashCode() + value.hashCode();
	}
}//end TechnicalSpecification