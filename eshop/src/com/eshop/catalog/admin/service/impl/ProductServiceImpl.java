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

import com.eshop.catalog.admin.service.ProductService;
import com.eshop.catalog.model.CategorizedProduct;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.persistence.ProductDAO;
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
		//This adds assocoiation from productSpec to product. Spring form binding does not take care of this.
		product.getProductSpec().setProduct(product);
		
		Product savedProduct = productDAO.makePersistent(product);
		for (CategorizedProduct categorizedProduct : product.getCategorizedProducts()){
			categorizedProduct.setProduct(savedProduct);
		}

		return savedProduct;
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
	public Product deleteProduct(Long productId) {
		Product product = productDAO.getReference(productId);
		productDAO.delete(product);
		return product;
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
