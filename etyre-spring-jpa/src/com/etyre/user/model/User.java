package com.etyre.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 3:45:32 PM
 */
@Entity
@Table(name="users")
public class User implements Serializable {

	private Long id;

	private int version;

	private Name name;

	private String screenName;

	private String password;

	private Address homeAddress;

	private Address billingAddress;

	private Address shippingAddress;

	private ContactInfo contactInfo;

	public User() {

	}

	public User(String screenName, String password) {
		this.screenName = screenName;
		this.password = password;
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

	@Embedded
	public Name getName() {
		return name;
	}

	void setName(Name name) {
		this.name = name;
	}

	@Column(length = 250, nullable = false, unique = true)
	public String getScreenName() {
		return screenName;
	}

	private void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Column(length = 250)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne
	@JoinColumn(name = "home_address_id", nullable = false)
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@OneToOne
	@JoinColumn(name = "billing_address_id")
	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@OneToOne
	@JoinColumn(name = "shipping_address_id")
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void addName(String title, String firstName, String familyName) {
		new Name(this, title, firstName, familyName);
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
		if (!(other instanceof User)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final User that = (User) other;
		return this.screenName.equals(that.getScreenName());
	}

	public int hashCode() {
		return screenName.hashCode();
	}
}//end User