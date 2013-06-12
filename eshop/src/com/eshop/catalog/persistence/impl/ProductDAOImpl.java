package com.eshop.catalog.persistence.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.persistence.ProductDAO;
import com.sun.org.apache.xpath.internal.Expression;

@Repository("productDAO")
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

	private Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	public ProductDAOImpl() {
		super(Product.class);
	}

	public List<Product> findProductsByDimension(List<Dimension> dimensions) {
		
		List<Dimension> dimensionListCopy = new ArrayList<Dimension>();
		dimensionListCopy.addAll(dimensions);
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> product = cq.from(Product.class);
		cq.select(product);
		Join<Product, ProductSpec> productSpecJoin =  product.join("productSpec");
		Join<ProductSpec, Dimension> dimensionJoin = productSpecJoin.join("dimensions");
		Predicate dimensionNameCondition = cb.equal(dimensionJoin.get("dimensionProperty").get("name"), cb.parameter(String.class, "dimensionPropertyName0"));
		Predicate dimensionValueCondition = cb.equal(dimensionJoin.get("dimensionValue"), cb.parameter(String.class, "dimensionValue0"));
		Predicate dimensionCondition = cb.and(dimensionNameCondition, dimensionValueCondition);
		
		dimensionListCopy.remove(0);
		Subquery<Product> sq = cq.subquery(Product.class);
		sq = addDimensionExistsSubQueryRecursively(dimensionListCopy, 1, sq, cb);
		cq.where(cb.and(dimensionCondition, cb.exists(sq)));
		
		Query query = getEntityManager().createQuery(cq);
		
		for (int i = 0; i < dimensions.size(); i++){
			Dimension dimension = dimensions.get(i);
			query.setParameter("dimensionPropertyName"+i, dimension.getDimensionProperty().getName());
			query.setParameter("dimensionValue"+i, dimension.getDimensionValue());
		}

		List<Product> products = (List<Product>)query.getResultList();
		return products;
	}

	public Subquery<Product> addDimensionExistsSubQueryRecursively(List<Dimension> dimensions, int index , Subquery<Product> sq, CriteriaBuilder cb){
		Root<Product> product = sq.from(Product.class);
		sq.select(product);
		Join<Product, ProductSpec> productSpecJoin =  product.join("productSpec");
		Join<ProductSpec, Dimension> dimensionJoin = productSpecJoin.join("dimensions");
		Predicate dimensionNameCondition = cb.equal(dimensionJoin.get("dimensionProperty").get("name"), cb.parameter(String.class, "dimensionPropertyName"+index));
		Predicate dimensionValueCondition = cb.equal(dimensionJoin.get("dimensionValue"), cb.parameter(String.class, "dimensionValue"+index));
		Predicate dimensionCondition = cb.and(dimensionNameCondition, dimensionValueCondition);

		dimensions.remove(0);
		if (dimensions.isEmpty()){
			sq.where(dimensionCondition);
			return sq;
		}
		
		Subquery<Product> sqChild = sq.subquery(Product.class);
		index++;
		sqChild = addDimensionExistsSubQueryRecursively(dimensions, index, sqChild, cb);
		
		sq.where(cb.and(dimensionCondition, cb.exists(sqChild)));
		return sq;
	}
	
	public List<Product> getProductByTechSpec(Map<String, String> techSpecMap) {
		return null;
	}

	@Override
	public Product getProduct(Long productId) {
		Query query = getEntityManager().createNamedQuery("getProduct");
		query.setParameter("productId", productId);
		query.setMaxResults(1);
		Product product = (Product) query.getSingleResult();
		Hibernate.initialize(product.getImages());
		Hibernate.initialize(product.getProductSpec().getTechSpecs());
		for (TechSpec techSpec : product.getProductSpec().getTechSpecs()) {
			Hibernate.initialize(techSpec.getTechSpecProperty().getCategory());
		}
		Hibernate.initialize(product.getProductSpec().getDimensions());
		for (Dimension dimension : product.getProductSpec().getDimensions()) {
			Hibernate.initialize(dimension.getDimensionProperty().getCategory());
		}
		return product;
	}

}
