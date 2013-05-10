package com.eshop.catalog.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 29-Sep-2012 8:48:07 PM
 */
@Entity
@Table(name="brand")
public class Brand implements Serializable {

	private Long id;
	
	private int version;

	private String name;

	private String description;

	private Media logoImage;

	public Brand() {

	}

	public Brand(String name, String description, Media logoImage) {
		this.name = name;
		this.description = description;
		this.logoImage = logoImage;
	}

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

	@Column(nullable = false, unique = true, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 4000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Embedded
	public Media getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(Media logoImage) {
		this.logoImage = logoImage;
	}


	/**
	 * If this object is used as detached object, it can be outside guaranteed scope identity of persistence context.
	 * In this case there can be two different objects representing the same row in database. They will have same database identity 
	 * but different java identity. 
	 * Hence override equals and hashcode method as default check only java identity.
	 * 
	 * Use a business key comparison in the equals method. Business key characteristics are uniqueness, non-nullability and rare change.
	 * 
	 * Using id comparison in equals is strongly discouraged as id is assigned by Hibernate only after persistence. This can result in 
	 * changed hash value after object is added to a SET(Collection). This breaks SET contract.
	 * 
	 * Always use getters to compare properties of other object. This is to make sure the code works even if proxies are passed instead
	 * of real objects.
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Brand)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Brand that = (Brand) other;
		return this.name.equals(that.getName());
	}

	public int hashCode() {
		return name.hashCode();
	}

}//end Brand