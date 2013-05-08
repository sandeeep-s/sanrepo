package com.etyre.user.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 3:45:32 PM
 */
@Entity
@Table(name = "contact_info")
public class ContactInfo implements Serializable {

	private Long id;

	private int version;

	private User user;

	private EmailAddress primaryEmailAddress;

	private EmailAddress alternateEmailAddress;

	private PhoneNumber landlinePhoneNo;

	private PhoneNumber mobilePhoneNo;

	private ContactInfo() {

	}

	public ContactInfo(User user, EmailAddress primaryEmailAddress, PhoneNumber mobilePhoneNo) {
		this.primaryEmailAddress = primaryEmailAddress;
		this.mobilePhoneNo = mobilePhoneNo;

		user.setContactInfo(this);
	}

	public ContactInfo(User user, EmailAddress primaryEmailAddress, EmailAddress alternateEmailAddress, PhoneNumber landlinePhoneNo,
			PhoneNumber mobilePhoneNo) {
		this.primaryEmailAddress = primaryEmailAddress;
		this.alternateEmailAddress = alternateEmailAddress;
		this.landlinePhoneNo = landlinePhoneNo;
		this.mobilePhoneNo = mobilePhoneNo;

		user.setContactInfo(this);
	}

	@Id
	@GeneratedValue(generator = "contactForiegnGenerator")
	@org.hibernate.annotations.GenericGenerator(name = "contactForiegnGenerator", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
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

	@OneToOne(mappedBy = "contactInfo")
	public User getUser() {
		return user;
	}

	private void setUser(User user) {
		this.user = user;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "emailId", column = @Column(name = "primary_email_id", nullable = false)) })
	public EmailAddress getPrimaryEmailAddress() {
		return primaryEmailAddress;
	}

	public void setPrimaryEmailAddress(EmailAddress primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "emailId", column = @Column(name = "alternate_email_id")) })
	public EmailAddress getAlternateEmailAddress() {
		return alternateEmailAddress;
	}

	public void setAlternateEmailAddress(EmailAddress alternateEmailAddress) {
		this.alternateEmailAddress = alternateEmailAddress;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "landline_phone_type")),
			@AttributeOverride(name = "countryCode", column = @Column(name = "landline_country_code")),
			@AttributeOverride(name = "number", column = @Column(name = "landline_phone_number")) })
	public PhoneNumber getLandlinePhoneNo() {
		return landlinePhoneNo;
	}

	public void setLandlinePhoneNo(PhoneNumber landlinePhoneNo) {
		this.landlinePhoneNo = landlinePhoneNo;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "mobile_phone_type", nullable = false)),
			@AttributeOverride(name = "countryCode", column = @Column(name = "mobile_country_code", nullable = false)),
			@AttributeOverride(name = "number", column = @Column(name = "mobile_phone_number", nullable = false)) })
	public PhoneNumber getMobilePhoneNo() {
		return mobilePhoneNo;
	}

	public void setMobilePhoneNo(PhoneNumber mobilePhoneNo) {
		this.mobilePhoneNo = mobilePhoneNo;
	}

	public boolean equals(Object other) {
		if (!(other instanceof ContactInfo)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final ContactInfo that = (ContactInfo) other;
		return this.user.equals(that.getUser());
	}

	public int hashCode() {
		return user.hashCode();
	}
}//end ContactInfo