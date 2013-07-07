package com.eshop.common.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.base.form.BaseForm;
import com.eshop.common.model.MediaType;

public class MediaForm extends BaseForm {

	private MediaType mediaType;

	private String mediaFileName;

	private String mediaName;

	private String mediaThumbnailFileName;

	private MultipartFile mediaFile;

	public MediaForm() {

	}

	public MediaForm(MediaType mediaType, String mediaFileName, String mediaName, String mediaThumbnailFileName, String thumbnailName) {
		this.mediaType = mediaType;
		this.mediaFileName = mediaFileName;
		this.mediaName = mediaName;
		this.mediaThumbnailFileName = mediaThumbnailFileName;
	}

	@NotNull
	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	@NotBlank
	public String getMediaFileName() {
		return mediaFileName;
	}

	public void setMediaFileName(String mediaFileName) {
		this.mediaFileName = mediaFileName;
	}

	@NotBlank
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	@NotBlank
	public String getMediaThumbnailFileName() {
		return mediaThumbnailFileName;
	}

	public void setMediaThumbnailFileName(String mediaThumbnailFileName) {
		this.mediaThumbnailFileName = mediaThumbnailFileName;
	}

	public MultipartFile getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(MultipartFile mediaFile) {
		this.mediaFile = mediaFile;
	}

}
