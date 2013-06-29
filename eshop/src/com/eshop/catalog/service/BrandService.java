/**
 * 
 */
package com.eshop.catalog.service;

import java.util.Set;

import com.eshop.catalog.model.Brand;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface BrandService {

	public Brand addBrand(Brand brand);

	public Brand getBrandById(Long brandId);

	public Brand updateBrand(Brand brand);

	public Brand deleteBrand(Long brandId);

	public Set<Brand> getAllBrands();

	public Brand createBrand(String brandName, Media logoImage);

}
