package com.etyre.common.service;

import com.etyre.common.model.Media;
import com.etyre.common.model.MediaType;

public interface MediaService {
	
	public Media createMedia(MediaType mediatype, String fileLocaton, String name, String thumbnailLocation, String thumbnailName);
	
}
