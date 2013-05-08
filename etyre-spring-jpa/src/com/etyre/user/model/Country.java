package com.etyre.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 4:37:07 PM
 */
@Entity
public class Country implements Serializable{

	private Long id;

	private int version;

	/**
	 * International Direct Dialing Code.(Telephone country code)
	 */
	private String iddCode;

	/**
	 * ISO country code comprising two characters 
	 */
	private String isoCodeTwo;

	/**
	 * ISO country code comprising three characters 
	 */
	private String isoCodeThree;

	/**
	 * ISO numeric country code  
	 */
	private String isoNumericCode;

	/**
	 * Country name
	 */
	private String name;

	public Country() {

	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	@Column(nullable=false,unique=true,length=5)
	public String getIddCode() {
		return iddCode;
	}

	private void setIddCode(String iddCode) {
		this.iddCode = iddCode;
	}

	@Column(nullable=false,unique=true,length=2)
	public String getIsoCodeTwo() {
		return isoCodeTwo;
	}

	private void setIsoCodeTwo(String isoCodeTwo) {
		this.isoCodeTwo = isoCodeTwo;
	}

	@Column(nullable=false,unique=true,length=3)
	private String getIsoCodeThree() {
		return isoCodeThree;
	}

	private void setIsoCodeThree(String isoCodeThree) {
		this.isoCodeThree = isoCodeThree;
	}

	@Column(nullable=false,unique=true,length=5)
	public String getIsoNumericCode() {
		return isoNumericCode;
	}

	private void setIsoNumericCode(String isoNumericCode) {
		this.isoNumericCode = isoNumericCode;
	}

	@Column(nullable=false,unique=true,length=250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other){
		if (!(other instanceof Country)){
			return false;
		}
		if (this == other){
			return true;
		}
		final Country that = (Country)other;
		return this.isoCodeTwo.equals(that.getIsoCodeTwo());
	}
	
	public int hashCode(){
		return isoCodeTwo.hashCode();
	}
	
}//end Country