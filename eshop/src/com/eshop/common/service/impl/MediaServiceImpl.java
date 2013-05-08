package com.eshop.common.service.impl;

import org.springframework.stereotype.Service;

import com.eshop.common.model.Media;
import com.eshop.common.model.MediaType;
import com.eshop.common.service.MediaService;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	@Override
	public Media createMedia(MediaType mediatype, String fileLocaton, String name, String thumbnailLocation, String thumbnailName) {
		Media media = new Media(mediatype, fileLocaton, name, thumbnailLocation, thumbnailName);
		return media;
	}

}
