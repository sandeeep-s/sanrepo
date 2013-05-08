/**
 * 
 */
package com.etyre.vehicle.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.etyre.vehicle.model.VehicleMake;


/**
 * @author ssd1kor
 * 
 */
@SuppressWarnings("serial")
public class VehicleForm implements Serializable {

	private Long id;

	private VehicleMake make;

	private String model;

	private String subModel;

	private Integer manufacturingYear;

	private String imageURL;

	private MultipartFile image;

	public VehicleForm() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehicleMake getMake() {
		return make;
	}

	public void setMake(VehicleMake make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSubModel() {
		return subModel;
	}

	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
