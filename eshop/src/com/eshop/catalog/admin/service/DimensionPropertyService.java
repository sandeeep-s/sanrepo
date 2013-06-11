/**
 * 
 */
package com.eshop.catalog.admin.service;

import java.util.Set;

import com.eshop.catalog.model.DimensionProperty;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface DimensionPropertyService {

	public DimensionProperty addDimensionProperty(DimensionProperty dimensionProperty);

	public DimensionProperty getDimensionPropertyById(Long dimensionPropertyId);

	public DimensionProperty updateDimensionProperty(DimensionProperty dimensionProperty);

	public DimensionProperty deleteDimensionProperty(Long dimensionPropertyId);

	public Set<DimensionProperty> getAllDimensionPropertys();

	public DimensionProperty createDimensionProperty(String dimensionPropertyName, Media logoImage);

	public DimensionProperty getDimensionPropertyByName(String dimensionPropertyName);

}
