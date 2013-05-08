package com.eshop.common.service;

import com.eshop.common.model.Media;
import com.eshop.common.model.MediaType;

public interface MediaService {
	
	public Media createMedia(MediaType mediatype, String fileLocaton, String name, String thumbnailLocation, String thumbnailName);
	
}
