/**
 * 
 */
package com.eshop.catalog.service;

import java.util.Set;

import com.eshop.catalog.model.Product;

/**
 * @author ssd1kor
 * 
 */
public interface ProductService {

	public Product addProduct(Product product);

	public Product getProductById(Long productId);

	public Product updateProduct(Product product);

	public Product deleteProduct(Long productId);

	public Set<Product> getAllProducts();

	public Product createProduct();

}
