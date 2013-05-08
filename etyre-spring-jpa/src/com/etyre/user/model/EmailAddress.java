package com.etyre.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 4:06:03 PM
 */
@Embeddable
@org.hibernate.annotations.Immutable
public class EmailAddress implements Serializable{

	private String emailId;

	private EmailAddress(){

	}

	public EmailAddress(String emailId){
		this.emailId = emailId;
	}

	@Column(length=50)
	public String getEmailId() {
		return emailId;
	}

	private void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean equals(Object other){
		if (!(other instanceof EmailAddress)){
			return false;
		}
		if (this == other){
			return false;
		}
		final EmailAddress that = (EmailAddress)other;
		return this.emailId.equals(that.getEmailId());
	}
	
	public int hashCode(){
		return emailId.hashCode();
	}
	
}//end EmailAddress