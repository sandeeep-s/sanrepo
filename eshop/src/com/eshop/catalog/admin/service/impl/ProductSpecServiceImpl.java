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

import com.eshop.catalog.admin.service.ProductSpecService;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.persistence.ProductSpecDAO;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("productSpecService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductSpecServiceImpl implements ProductSpecService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductSpecServiceImpl.class);

	@Inject
	private ProductSpecDAO productSpecDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addProductSpec(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ProductSpec addProductSpec(ProductSpec productSpec) {
		return productSpecDAO.makePersistent(productSpec);
	}

	@Override
	public ProductSpec getProductSpecById(Long productSpecId) {
		return productSpecDAO.findById(productSpecId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public ProductSpec updateProductSpec(ProductSpec productSpec) {
		return productSpecDAO.saveOrUpdate(productSpec);
	}

	@Override
	public ProductSpec deleteProductSpec(Long productSpecId) {
		ProductSpec productSpec = productSpecDAO.getReference(productSpecId);
		productSpecDAO.delete(productSpec);
		return productSpec;
	}

	@Override
	public Set<ProductSpec> getAllProductSpecs() {
		return productSpecDAO.findAllUnique();
	}

	@Override
	public ProductSpec createProductSpec(String name, Media logoImage) {
		ProductSpec productSpec = new ProductSpec();
		return productSpec;
	}

}
