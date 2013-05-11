/**
 * 
 */
package com.eshop.catalog.admin.service;

import java.util.Set;

import com.eshop.catalog.model.TechSpec;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface TechSpecService {

	public TechSpec addTechSpec(TechSpec techSpec);

	public TechSpec getTechSpecById(Long techSpecId);

	public TechSpec updateTechSpec(TechSpec techSpec);

	public void deleteTechSpec(Long techSpecId);

	public Set<TechSpec> getAllTechSpecs();

	public TechSpec createTechSpec(String techSpecName, Media logoImage);

}
