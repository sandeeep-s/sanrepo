package com.eshop.productsearch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.catalog.admin.service.DimensionPropertyService;
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.model.Product;
import com.eshop.productsearch.service.ProductSearchService;

@Controller
public class TireSearchByDimensionsController {

	
	
	@RequestMapping("/product/category/tire/dimension/front/{frontSection}/{frontAspectRatio}/{frontDiameter}/rear/{rearSection}/{rearAspectRatio}/{rearDiameter}")
	public String listProductsMatchingOriginalFitment(@PathVariable String frontSection, @PathVariable String frontAspectRatio,
			@PathVariable String frontDiameter, @PathVariable String rearSection, @PathVariable String rearAspectRatio, @PathVariable String rearDiameter) {
		return null;
	}


	
}
