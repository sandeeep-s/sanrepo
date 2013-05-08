/*******************************************************************************
 * Copyright (c) 2007, 2012 Sony Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of Sony Public License v1.0 which
 * accompanies this distribution, and is available at http://www.sony.com
 * 
 * Contributors: Sony India Software Center (SISC/ORMC)
 *******************************************************************************/
package com.etyre.base.exception;

/**
 * @author 501200c251
 * 
 */
public class ImageUploadException extends RuntimeException {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ImageUploadException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ImageUploadException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImageUploadException(String message, Throwable cause) {
		super(message, cause);
	}

}