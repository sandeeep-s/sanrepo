/**
 * 
 */
package com.eshop.catalog.service;

import java.util.Set;

import com.eshop.catalog.model.Product;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface ProductService {

	public Product addProduct(Product product);

	public Product getProductById(Long productId);

	public Product updateProduct(Product product);

	public void deleteProduct(Long productId);

	public Set<Product> getAllProducts();

	public Product createProduct(String productName, Media logoImage);

}
