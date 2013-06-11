package com.eshop.catalog.persistence.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eshop.base.persistence.impl.GenericDAOImpl;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.persistence.ProductDAO;

@Repository("productDAO")
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

	private Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	public ProductDAOImpl() {
		super(Product.class);
	}

	public List<Product> findProductsByDimension(List<Dimension> dimensions) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select product");
		queryBuilder.append(" ");
		queryBuilder.append("from Product product join product.productSpec productSpec join productSpec.dimensions dimensions");
		queryBuilder.append(" ");
		queryBuilder.append("where dimensions.dimensionProperty.name = :dimensionPropertyName0 and dimensions.dimensionValue = :dimensionValue0");
		queryBuilder.append(" ");
		for (int i = 1; i < dimensions.size(); i++){
			queryBuilder.append(" ");
			queryBuilder.append("and exists (");
			queryBuilder.append(" ");
			queryBuilder.append("select product"+i);
			queryBuilder.append(" ");
			queryBuilder.append("from Product product"+i+" join product"+i+".productSpec productSpec"+i+" join productSpec"+i+".dimensions dimensions"+i+"");
			queryBuilder.append(" ");
			queryBuilder.append("where dimensions"+i+".dimensionProperty.name = :dimensionPropertyName"+i+" and dimensions"+i+".dimensionValue = :dimensionValue"+i+" and product = product"+i);
		}

		for (int i = 1; i < dimensions.size(); i++){
			queryBuilder.append(" ");
			queryBuilder.append(")");
		}

		String queryString = queryBuilder.toString();
		logger.debug("findProductsByDimension queryString="+queryString);

		Query query = getEntityManager().createQuery(queryString);
		for (int i = 0; i < dimensions.size(); i++){
			Dimension dimension = dimensions.get(i);
			logger.debug("dimension.getDimensionProperty()="+dimension.getDimensionProperty());
			query.setParameter("dimensionPropertyName"+i, dimension.getDimensionProperty().getName());
			query.setParameter("dimensionValue"+i, dimension.getDimensionValue());
		}

		List<Product> products = (List<Product>)query.getResultList();
		return products;
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
