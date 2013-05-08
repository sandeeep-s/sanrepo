package com.etyre.catalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This class represents image of a product. It is a value type as it is owned by
 * Product class. It does not support shared references. Hence association with
 * product is realized through constructor at creation time itself. Also it is
 * made immutable by marking all setters as private. It is also annotated as
 * Immutable. This helps hibernate to make some performance optimizations.
 * @author ssd1kor
 * @version 1.0
 * @updated 17-Oct-2012 3:50:24 PM
 */
@Embeddable
@org.hibernate.annotations.Immutable
public class ProductImage implements Serializable {

	private String name;

	/*Filename of the image file*/
	private String fileName;

	private String thumbnailName;

	private String thumbnailFileName;

	/**Marked as private as client should always use the other constructor
	 * Hibernate needs this default constructor.
	 * 
	 */
	private ProductImage() {

	}

	/**
	 * Constructor to create object with all values.
	 * Product object is also passed to realize the association at the construction time itself as ProductImage object does not support shared references
	 * @param product
	 * @param name
	 * @param fileName
	 * @param thumbnailName
	 * @param thumbnailFileName
	 */
	public ProductImage(Product product, String name, String fileName, String thumbnailName, String thumbnailFileName) {
		this.name = name;
		this.fileName = fileName;
		this.thumbnailName = thumbnailName;
		this.thumbnailFileName = thumbnailFileName;

		product.getImages().add(this);
	}

	@Column(nullable = false, unique = true, length = 250)
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, unique = true, length = 250)
	public String getFileName() {
		return fileName;
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(nullable = false, unique = true, length = 250)
	public String getThumbnailName() {
		return thumbnailName;
	}

	private void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	@Column(nullable = false, unique = true, length = 250)
	public String getThumbnailFileName() {
		return thumbnailFileName;
	}

	private void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}

	public boolean equals(Object other) {
		if (!(other instanceof ProductImage)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final ProductImage that = (ProductImage) other;
		return this.name.equals(that.getName()) && this.fileName.equals(that.getFileName()) && this.thumbnailName.equals(that.getThumbnailName())
				&& this.thumbnailFileName.equals(that.getThumbnailFileName());
	}

	public int hashCode() {
		return name.hashCode() + fileName.hashCode() + thumbnailName.hashCode() + thumbnailFileName.hashCode();
	}
}//end ProductImage