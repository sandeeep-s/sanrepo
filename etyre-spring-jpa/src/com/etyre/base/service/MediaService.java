package com.etyre.base.service;

import org.springframework.web.multipart.MultipartFile;

public interface MediaService {

	public void saveImage(String webRootPath, String fileName, MultipartFile image);
}
