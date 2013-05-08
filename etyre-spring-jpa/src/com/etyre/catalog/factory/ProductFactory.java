/**
 * 
 */
package com.etyre.catalog.factory;

import java.util.Set;

import com.etyre.catalog.model.Brand;
import com.etyre.catalog.model.Category;
import com.etyre.catalog.model.Dimensions;
import com.etyre.catalog.model.Product;
import com.etyre.catalog.model.ProductImage;
import com.etyre.catalog.model.Promotion;
import com.etyre.catalog.model.TechnicalSpecification;

/**
 * @author ssd1kor
 *
 */
public class ProductFactory {

	public Product createProduct(Brand brand, String name, String description, Dimensions dimensions,
			Set<TechnicalSpecification> technicalSpecifications, Set<ProductImage> images, Set<Promotion> promotions,
			Category category) {
		
		Product product = new Product(brand, name, description);
		
		product.addDimesions(dimensions.getLength(), dimensions.getLengthUnit(), dimensions.getWidth(), dimensions.getWidthUnit(),
				dimensions.getHeight(), dimensions.getHeightUnit(), dimensions.getVolume(), dimensions.getVolumeUnit(),
				dimensions.getWeight(), dimensions.getWeightUnit());
		
		for (TechnicalSpecification ts : technicalSpecifications){
			product.addTechnicalSpecification(ts.getTechSpecDefinition(), ts.getValue());
		}
		
		for (ProductImage image : images){
			product.addImage(image.getName(), image.getFileName(), image.getThumbnailName(), image.getThumbnailFileName());
		}
		
		for (Promotion promotion : promotions){
			product.addPromotion(promotion);
		}
		
		category.addProduct(product);
		
		return product;
	}

}
