package com.eshop.catalog.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="product_spec")
public class ProductSpec implements Serializable {

	private Long id;

	private int version;

	private Product product;

	private Pattern pattern;

	private Map<TechSpec, String> techSpecs;

	private Map<Dimension, String> dimensions;

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

	@OneToOne
	@JoinColumn(name = "product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne
	@JoinColumn(name = "pattern_id")
	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	@ElementCollection
	@CollectionTable(name = "product_tech_spec", joinColumns = @JoinColumn(name = "product_spec_id"))
	@MapKeyJoinColumn(name = "tech_spec_id")
	public Map<TechSpec, String> getTechSpecs() {
		return techSpecs;
	}

	public void setTechSpecs(Map<TechSpec, String> techSpecs) {
		this.techSpecs = techSpecs;
	}

	@ElementCollection
	@CollectionTable(name = "product_dimension", joinColumns = @JoinColumn(name = "product_spec_id"))
	@MapKeyJoinColumn(name = "dimension_id")
	public Map<Dimension, String> getDimensions() {
		return dimensions;
	}

	public void setDimensions(Map<Dimension, String> dimensions) {
		this.dimensions = dimensions;
	}

}
