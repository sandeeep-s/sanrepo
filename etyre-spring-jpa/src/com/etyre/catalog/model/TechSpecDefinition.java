package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 03-Oct-2012 9:57:15 PM
 */
@Entity
@Table(
		name="tech_spec_definition",
		uniqueConstraints=@UniqueConstraint(name="tsdef_name_cat_uniq",columnNames={"name","category_id"})
)
public class TechSpecDefinition implements Serializable{

	private Long id;

	private int version;

	private String name;

	private String unit;

	private String description;

	private Category category;

	private TechSpecDefinition() {

	}

	public TechSpecDefinition(String name, String unit, String description, Category category) {
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	private void setVersion(int version) {
		this.version = version;
	}

	@Column(nullable=false,length=250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable=false,length=50)
	public String getUnit() {
		return unit;
	}

	private void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(nullable=false,length=4000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	public Category getCategory() {
		return category;
	}

	private void setCategory(Category category) {
		this.category = category;
	}

	public boolean equals(Object other){
		if (!(other instanceof TechSpecDefinition)){
			return false;
		}
		if(this == other){
			return true;
		}
		final TechSpecDefinition that = (TechSpecDefinition)other;
		return this.name.equals(that.getName()) && this.category.equals(that.getCategory());
	}
	
	public int hashCode(){
		return name.hashCode() + category.hashCode();
	}

}//end TechSpecDefinition