package com.etyre.base.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etyre.base.exception.ImageUploadException;
import com.etyre.base.service.MediaService;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MediaServiceImpl.class); 
	
	private String resourceRootPath;
	
	public String getResourceRootPath() {
		return resourceRootPath;
	}

	public void setResourceRootPath(String resourceRootPath) {
		this.resourceRootPath = resourceRootPath;
	}

	@Override
	public void saveImage(String webRootPath, String fileName, MultipartFile image) {
		
		LOGGER.debug("webRootPath="+webRootPath);
		LOGGER.debug("webRootPath="+fileName);
		try {
			File file = new File(webRootPath+"/resources/images/" + fileName);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image", e);
		}
	}

}
