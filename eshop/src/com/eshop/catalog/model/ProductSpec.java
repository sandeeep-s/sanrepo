package com.eshop.catalog.model;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.eshop.base.model.EntityBase;

@Entity
@Table(name = "product_spec")
public class ProductSpec extends EntityBase {

	private Product product;

	private Pattern pattern;

	private List<TechSpec> techSpecs;

	private List<Dimension> dimensions;

	public ProductSpec(){
		
	}

	public ProductSpec(Product product, Pattern pattern, List<TechSpec> techSpecs, List<Dimension> dimensions){
		this.product = product;
		this.pattern = pattern;
		this.techSpecs = techSpecs;
		this.dimensions = dimensions;
		
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable=false)
	public Product getProduct() {
		return product;
	}

	void setProduct(Product product) {
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

	private void setPattern(Pattern pattern) {
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
