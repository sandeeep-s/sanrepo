package com.eshop.catalog.factory.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eshop.catalog.factory.ProductFactory;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.model.TechSpec;
import com.eshop.common.model.Media;

@Component("productFactory")
public class ProductFactoryImpl implements ProductFactory {

	@Override
	public Product createProduct() {
		Product product = new Product();
		ProductSpec productSpec = new ProductSpec();

		List<TechSpec> techSpecList = new ArrayList<TechSpec>();
		TechSpec techSpec = new TechSpec();
		techSpecList.add(techSpec);
		productSpec.setTechSpecs(techSpecList);

		List<Dimension> dimensionList = new ArrayList<Dimension>();
		Dimension dimension = new Dimension();
		dimensionList.add(dimension);
		productSpec.setDimensions(dimensionList);

		product.addProductSpec(productSpec);

		List<Media> images = new ArrayList<Media>();
		images.add(new Media());
		product.setImages(images);
		
		return product;
	}

}
