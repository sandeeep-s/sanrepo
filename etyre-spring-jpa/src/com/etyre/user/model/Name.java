package com.etyre.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 3:58:25 PM
 */
@Embeddable
@org.hibernate.annotations.Immutable
public class Name implements Serializable {

	private String title;

	private String firstName;

	private String middleName;

	private String familyName;

	private Name() {

	}

	public Name(User user, String title, String firstName, String familyName) {
		this.title = title;
		this.firstName = firstName;
		this.familyName = familyName;

		user.setName(this);
	}

	public Name(User user, String title, String firstName, String middleName, String familyName) {
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.familyName = familyName;

		user.setName(this);
	}

	@Column(nullable = false, length = 250)
	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false, length = 250)
	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(length = 250)
	public String getMiddleName() {
		return middleName;
	}

	private void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(nullable = false, length = 250)
	public String getFamilyName() {
		return familyName;
	}

	private void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Name)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final Name that = (Name) other;
		return this.title.equals(that.getTitle()) && this.firstName.equals(that.getFirstName())
				&& this.middleName.equals(that.getMiddleName()) && this.familyName.equals(that.getFamilyName());
	}

	public int hashCode() {
		return title.hashCode() + firstName.hashCode() + middleName.hashCode() + familyName.hashCode();
	}

}//end Name