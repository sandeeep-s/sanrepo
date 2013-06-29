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

import com.eshop.catalog.factory.ProductFactory;
import com.eshop.catalog.model.CategorizedProduct;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.persistence.ProductDAO;
import com.eshop.catalog.service.ProductService;

/**
 * @author ssd1kor
 * 
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Inject
	private ProductDAO productDAO;

	@Inject
	private ProductFactory productFactory;

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
		product.addProductSpec(product.getProductSpec());

		Product savedProduct = productDAO.save(product);
		for (CategorizedProduct categorizedProduct : product.getCategorizedProducts()) {
			categorizedProduct.setProduct(savedProduct);
		}

		return savedProduct;
	}

	@Override
	public Product getProductById(Long productId) {
		//return productDAO.findById(productId);
		return productDAO.getProduct(productId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public Product updateProduct(Product product) {
		for (CategorizedProduct categorizedProduct : product.getCategorizedProducts()) {
			categorizedProduct.setProduct(product);
			logger.debug("product id=" + product.getId());
			logger.debug("categorizedProduct product id=" + categorizedProduct.getProduct().getId());
		}
		product.addProductSpec(product.getProductSpec());
		//Not sending back the returned product from saveOrUpdate call DAO as it will not be fully initialized.
		//Safe to send back the passed in product as it will be the latest if saved successfully
		productDAO.saveOrUpdate(product);
		return product;
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
	public Product createProduct() {
		Product product = productFactory.createProduct();
		return product;
	}

}
