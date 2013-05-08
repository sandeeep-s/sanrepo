package com.etyre.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 4:06:10 PM
 */
@Embeddable
@org.hibernate.annotations.Immutable
public class PhoneNumber implements Serializable{

	private String type;

	private String countryCode;

	private String number;

	private PhoneNumber() {

	}

	public PhoneNumber(String type, String countryCode, String number) {
		this.type = type;
		this.countryCode = countryCode;
		this.number = number;
	}

	@Column(length=10)
	public String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	@Column(length=10)
	public String getCountryCode() {
		return countryCode;
	}

	private void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Column(length=25)
	public String getNumber() {
		return number;
	}

	private void setNumber(String number) {
		this.number = number;
	}

	public boolean equals(Object other) {
		if (!(other instanceof PhoneNumber)) {
			return false;
		}

		if (this == other) {
			return true;
		}
		final PhoneNumber that = (PhoneNumber) other;
		return this.type.equals(that.getType()) && this.countryCode.equals(that.getCountryCode()) && this.number.equals(that.getNumber());
	}

	public int hashCode() {
		return type.hashCode() + countryCode.hashCode() + number.hashCode();
	}
}//end PhoneNumber