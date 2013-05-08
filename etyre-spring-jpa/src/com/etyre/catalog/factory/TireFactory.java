/**
 * 
 */
package com.etyre.catalog.factory;

import java.util.Set;

import com.etyre.catalog.model.Brand;
import com.etyre.catalog.model.Category;
import com.etyre.catalog.model.Dimensions;
import com.etyre.catalog.model.ProductImage;
import com.etyre.catalog.model.Promotion;
import com.etyre.catalog.model.TechnicalSpecification;
import com.etyre.catalog.model.Tire;
import com.etyre.catalog.model.TirePattern;
import com.etyre.catalog.model.TireSize;

/**
 * @author ssd1kor
 *
 */
public class TireFactory {

	public Tire createTire(Brand brand, String name, String description, TirePattern pattern, TireSize tireSize, Dimensions dimensions,
			Set<TechnicalSpecification> technicalSpecifications, Set<ProductImage> images, Set<Promotion> promotions, Category category) {

		Tire tire = new Tire(brand, name, description, pattern);

		tire.addDimesions(dimensions.getLength(), dimensions.getLengthUnit(), dimensions.getWidth(), dimensions.getWidthUnit(),
				dimensions.getHeight(), dimensions.getHeightUnit(), dimensions.getVolume(), dimensions.getVolumeUnit(),
				dimensions.getWeight(), dimensions.getWeightUnit());

		for (TechnicalSpecification ts : technicalSpecifications) {
			tire.addTechnicalSpecification(ts.getTechSpecDefinition(), ts.getValue());
		}

		for (ProductImage image : images) {
			tire.addImage(image.getName(), image.getFileName(), image.getThumbnailName(), image.getThumbnailFileName());
		}

		for (Promotion promotion : promotions) {
			tire.addPromotion(promotion);
		}

		tire.addTireSize(tireSize.getServiceType(), tireSize.getSectionWidth(), tireSize.getAspectRatio(), tireSize.getSpeedRating(),
				tireSize.getInternalConstruction(), tireSize.getRunFlat(), tireSize.getDiameter(), tireSize.getServiceDescription());

		category.addProduct(tire);

		return tire;
	}

}
