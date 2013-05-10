/**
 * 
 */
package com.eshop.catalog.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.model.Product;
import com.eshop.catalog.persistence.ProductDAO;
import com.eshop.catalog.service.ProductService;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Inject
	private ProductDAO productDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addProduct(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Product addProduct(Product product) {
		return productDAO.makePersistent(product);
	}

	@Override
	public Product getProductById(Long productId) {
		return productDAO.findById(productId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public Product updateProduct(Product product) {
		return productDAO.saveOrUpdate(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = productDAO.getReference(productId);
		productDAO.delete(product);
	}

	@Override
	public Set<Product> getAllProducts() {
		return productDAO.findAllUnique();
	}

	@Override
	public Product createProduct(String name, Media logoImage) {
		Product product = new Product();
		return product;
	}

}
