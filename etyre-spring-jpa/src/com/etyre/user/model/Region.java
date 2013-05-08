package com.etyre.user.model;

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
 * @created 30-Sep-2012 4:49:13 PM
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "region_name_country_uniq", columnNames = { "name", "country_id" }))
public class Region implements Serializable {

	private Long id;

	private int version;

	private String name;

	private String regionCode;

	private Country country;

	public Region() {

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

	@Column(nullable = false, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(unique = true, length = 5)
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Region)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Region that = (Region) other;
		return this.country.equals(that.getCountry()) && this.name.equals(that.getName());
	}

	public int hashCode() {
		return country.hashCode() + name.hashCode();
	}
}//end Region