package com.eshop.productsearch.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class TireSearchByDimensionsController {

	@RequestMapping("/product/category/tire/dimension/front/{frontSection}/{frontAspectRatio}/{frontDiameter}/rear/{rearSection}/{rearAspectRatio}/{rearDiameter}")
	public String listProductsMatchingOriginalFitment(@PathVariable String frontSection, @PathVariable String frontAspectRatio,
			@PathVariable String frontDiameter, @PathVariable String rearSection, @PathVariable String rearAspectRatio, @PathVariable String rearDiameter) {
		return null;
	}

	@RequestMapping("/product/category/tire/dimension/{section}/{aspectRatio}/{diameter}")
	public String listProductsMatchingOriginalFitment(@PathVariable String section, @PathVariable String aspectRatio,
			@PathVariable String diameter) {
		return null;
	}

	
}
