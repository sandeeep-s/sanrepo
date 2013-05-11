/**
 * 
 */
package com.eshop.catalog.admin.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.admin.service.BrandService;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.persistence.BrandDAO;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("brandService")
@Transactional(propagation = Propagation.REQUIRED)
public class BrandServiceImpl implements BrandService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BrandServiceImpl.class);

	@Inject
	private BrandDAO brandDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addBrand(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Brand addBrand(Brand brand) {
		return brandDAO.makePersistent(brand);
	}

	@Override
	public Brand getBrandById(Long brandId) {
		return brandDAO.findById(brandId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public Brand updateBrand(Brand brand) {
		return brandDAO.saveOrUpdate(brand);
	}

	@Override
	public void deleteBrand(Long brandId) {
		Brand brand = brandDAO.getReference(brandId);
		brandDAO.delete(brand);
	}

	@Override
	public Set<Brand> getAllBrands() {
		return brandDAO.findAllUnique();
	}

	@Override
	public Brand createBrand(String name, Media logoImage) {
		Brand brand = new Brand();
		return brand;
	}

}
