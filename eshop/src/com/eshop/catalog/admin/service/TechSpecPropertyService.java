/**
 * 
 */
package com.eshop.catalog.admin.service;

import java.util.Set;

import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface TechSpecPropertyService {

	public TechSpecProperty addTechSpecProperty(TechSpecProperty techSpecProperty);

	public TechSpecProperty getTechSpecPropertyById(Long techSpecPropertyId);

	public TechSpecProperty updateTechSpecProperty(TechSpecProperty techSpecProperty);

	public TechSpecProperty deleteTechSpecProperty(Long techSpecPropertyId);

	public Set<TechSpecProperty> getAllTechSpecPropertys();

	public TechSpecProperty createTechSpecProperty(String techSpecPropertyName, Media logoImage);

}
