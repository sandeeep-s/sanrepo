package com.eshop.catalog.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "product_spec")
public class ProductSpec implements Serializable {

	private Long id;

	private int version;

	private Product product;

	private Pattern pattern;

	private List<TechSpec> techSpecs;

	private List<Dimension> dimensions;

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

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable=false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * The FetchType.EAGER will load the association eagerly.  
	 * FetchType.EAGER provides the guarantee that associated object will always be initialized alongwith the queried object.
	 * A single join query will be used to load the associated object while using JPA with Hibernate. But JPA does not mandate use of join for this initialization.
	 * FetchType.EAGER is the default for ManyToOne association in JPA.
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pattern_id")
	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	@ElementCollection
	@CollectionTable(name="product_tech_spec", joinColumns=@JoinColumn(name="product_spec_id"), uniqueConstraints = @UniqueConstraint(columnNames={"product_spec_id", "tech_spec_property_id"}))
	public List<TechSpec> getTechSpecs() {
		return techSpecs;
	}

	public void setTechSpecs(List<TechSpec> techSpecs) {
		this.techSpecs = techSpecs;
	}

	@ElementCollection
	@CollectionTable(name="product_dimension", joinColumns=@JoinColumn(name="product_spec_id"), uniqueConstraints = @UniqueConstraint(columnNames={"product_spec_id", "dimension_property_id"}))
	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

}
