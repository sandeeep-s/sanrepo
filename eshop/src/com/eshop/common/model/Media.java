/**
 * 
 */
package com.eshop.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ssd1kor
 *
 */

@Embeddable
public class Media implements Serializable {

	private MediaType mediaType;
	
	private String mediaFileName;

	private String mediaName;

	private String mediaThumbnailFileName;
	
	public Media(){
		
	}

	public Media(MediaType mediaType, String mediaFileName, String mediaName, String mediaThumbnailFileName, String thumbnailName) {
		this.mediaType = mediaType;
		this.mediaFileName = mediaFileName;
		this.mediaName = mediaName;
		this.mediaThumbnailFileName = mediaThumbnailFileName;
	}

	@NotNull
	@Column(nullable = false)
	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	@NotBlank
	@Column(length = 250, nullable=false)
	public String getMediaFileName() {
		return mediaFileName;
	}

	public void setMediaFileName(String mediaFileName) {
		this.mediaFileName = mediaFileName;
	}

	@NotBlank
	@Column(length = 250, nullable=false)
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	@NotBlank
	@Column(length = 250, nullable=false)
	public String getMediaThumbnailFileName() {
		return mediaThumbnailFileName;
	}

	public void setMediaThumbnailFileName(String mediaThumbnailFileName) {
		this.mediaThumbnailFileName = mediaThumbnailFileName;
	}

}
