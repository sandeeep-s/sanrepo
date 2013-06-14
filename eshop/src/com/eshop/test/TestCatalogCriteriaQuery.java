package com.eshop.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.model.TechSpec;

public class TestCatalogCriteriaQuery extends GenericDAOImpl<Product, Long> {

	public List<Pattern> getPatternsForBrand(Long brandId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Pattern> cq = cb.createQuery(Pattern.class);
		Root<Pattern> pattern = cq.from(Pattern.class);
		cq.select(pattern);
		cq.where(cb.equal(pattern.get("brand").get("id"), cb.parameter(Long.class, "brandId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("brandId", brandId);

		List<Pattern> patterns = query.getResultList();

		return patterns;
	}

	public List<Product> getProductsForPatterns(Long patternId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> product = cq.from(Product.class);
		Join<Product, ProductSpec> productSpec = product.join("productSpec");
		Join<ProductSpec, Pattern> pattern = productSpec.join("pattern");
		cq.select(product);
		cq.where(cb.equal(pattern.get("id"), cb.parameter(Long.class, "patternId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("patternId", patternId);

		List<Product> products = query.getResultList();

		return products;
	}

	public Product getProduct(Long productId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> product = cq.from(Product.class);
		Fetch<Product, Brand> brand = product.fetch("brand");
		Fetch<Product, ProductSpec> productSpec = product.fetch("productSpec");
		Fetch<ProductSpec, Pattern> pattern = productSpec.fetch("pattern");
		cq.select(product);
		cq.where(cb.equal(product.get("id"), cb.parameter(Long.class, "productId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("productId", productId);

		return (Product) query.getSingleResult();
	}

	public ProductSpec getProductSpecWithTechSpecs(Long productSpecId) {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProductSpec> cq = cb.createQuery(ProductSpec.class);
		Root<ProductSpec> productSpec = cq.from(ProductSpec.class);
		Fetch<ProductSpec, TechSpec> techSpecs = productSpec.fetch("techSpecs");
		cq.select(productSpec).distinct(true);
		cq.where(cb.equal(productSpec.get("id"), cb.parameter(Long.class, "productSpecId")));

		Query query = getEntityManager().createQuery(cq);
		query.setParameter("productSpecId", productSpecId);

		return (ProductSpec) query.getSingleResult();

	}

}
