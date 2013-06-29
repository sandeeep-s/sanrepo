/**
 * 
 */
package com.eshop.catalog.service;

import java.util.Set;

import com.eshop.catalog.model.ProductSpec;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface ProductSpecService {

	public ProductSpec addProductSpec(ProductSpec productSpec);

	public ProductSpec getProductSpecById(Long productSpecId);

	public ProductSpec updateProductSpec(ProductSpec productSpec);

	public ProductSpec deleteProductSpec(Long productSpecId);

	public Set<ProductSpec> getAllProductSpecs();

	public ProductSpec createProductSpec(String productSpecName, Media logoImage);

}
