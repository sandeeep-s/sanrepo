/**
 * 
 */
package com.eshop.catalog.service;

import java.util.Set;

import com.eshop.catalog.model.Dimension;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface DimensionService {

	public Dimension addDimension(Dimension dimension);

	public Dimension getDimensionById(Long dimensionId);

	public Dimension updateDimension(Dimension dimension);

	public void deleteDimension(Long dimensionId);

	public Set<Dimension> getAllDimensions();

	public Dimension createDimension(String dimensionName, Media logoImage);

}
