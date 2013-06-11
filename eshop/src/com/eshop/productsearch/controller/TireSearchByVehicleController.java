package com.eshop.productsearch.controller;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.catalog.model.Product;
import com.eshop.productsearch.form.TireFitmentForm;
import com.eshop.productsearch.service.TireFitmentSearchService;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.service.VehicleModelService;

@Controller
public class TireSearchByVehicleController {

	@Inject
	private TireFitmentSearchService tireFitmentSearchService;

	@Inject
	private VehicleModelService vehicleModelService;

	@RequestMapping(value = "/tirefitment/vehicle", method = RequestMethod.GET)
	public String displayVehicleSelectionForm(Model model) {
		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);

		return "vehicleSelection";
	}

	@RequestMapping("/tirefitment/original/category/{categoryId}/vehiclemodel/{vehicleModelId}")
	public String listOriginalFitmentsForVehicleModel(@PathVariable Long categoryId, @PathVariable Long vehicleModelId, Model model) {
		List<TireFitmentForm> tireFitmentForms = tireFitmentSearchService.searchFitmentByCategoryAndVehicleModel(categoryId,
				vehicleModelId, true);
		model.addAttribute("tireFitmentForms", tireFitmentForms);
		return "vehicleOriginalFitments";
	}

	@RequestMapping("/tirefitment/original/category/{categoryId}/vehiclesubmodel/{vehicleSubModelId}")
	public String listOriginalFitmentsForVehicleSubModel(@PathVariable Long categoryId, @PathVariable Long vehicleSubModelId) {
		return null;
	}

	@RequestMapping("/product/category/tire/dimension/{section}/{aspectRatio}/{diameter}")
	public String listOriginalFitmentProducts(@PathVariable String section, @PathVariable String aspectRatio,
			@PathVariable String diameter, Model model) {
		List<Product> products = tireFitmentSearchService.searchTiresByDimensions(section, aspectRatio, diameter);
		model.addAttribute("products", products);
		return "tireList";
	}

}
