package com.eshop.catalog.persistence.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.persistence.ProductDAO;

@Repository("productDAO")
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

	public ProductDAOImpl() {
		super(Product.class);
	}

	public List<Product> getProductsByDimension(Map<String, String> dimensionMap) {
		return null;
	}

	public List<Product> getProductByTechSpec(Map<String, String> techSpecMap) {
		return null;
	}

	@Override
	public Product getProduct(Long productId){
		Query query = getEntityManager().createNamedQuery("getProduct");
		query.setParameter("productId", productId);
		query.setMaxResults(1);
		Product product = (Product)query.getSingleResult();
		Hibernate.initialize(product.getImages());
		Hibernate.initialize(product.getProductSpec().getTechSpecs());
		Hibernate.initialize(product.getProductSpec().getDimensions());
		return product;
	}
	
}
