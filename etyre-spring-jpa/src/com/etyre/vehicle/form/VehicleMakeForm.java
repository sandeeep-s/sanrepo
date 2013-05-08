/**
 * 
 */
package com.etyre.vehicle.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ssd1kor
 * 
 */
@SuppressWarnings("serial")
public class VehicleMakeForm implements Serializable {

	private Long id;

	private String name;

	private String logoURL;

	private MultipartFile logoImage;

	public VehicleMakeForm() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public MultipartFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(MultipartFile logoImage) {
		this.logoImage = logoImage;
	}

}
