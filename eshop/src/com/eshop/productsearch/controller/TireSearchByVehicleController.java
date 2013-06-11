package com.eshop.productsearch.controller;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.productsearch.form.TireFitmentForm;
import com.eshop.productsearch.service.TireFitmentSearchService;
import com.eshop.productsearch.service.VehicleFitmentSearchService;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.service.VehicleModelService;
import com.eshop.vehiclefitment.model.VehicleFitment;

@Controller
@RequestMapping("/tirefitment")
public class TireSearchByVehicleController {

	@Inject
	private TireFitmentSearchService tireFitmentSearchService;

	@Inject
	private VehicleModelService vehicleModelService;
	
	@RequestMapping(value="/vehicle", method = RequestMethod.GET)
	public String displayVehicleSelectionForm(Model model) {
		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);
		
		return "vehicleSelection";
	}

	@RequestMapping("/original/category/{categoryId}/vehiclemodel/{vehicleModelId}")
	public String listOriginalFitmentsForVehicleModel(@PathVariable Long categoryId, @PathVariable Long vehicleModelId, Model model) {
		List<TireFitmentForm> tireFitmentForms = tireFitmentSearchService.searchFitmentByCategoryAndVehicleModel(categoryId,
				vehicleModelId, true);
		model.addAttribute("tireFitmentForms", tireFitmentForms);
		return "vehicleOriginalFitments";
	}

	@RequestMapping("/original/category/{categoryId}/vehiclesubmodel/{vehicleSubModelId}")
	public String listOriginalFitmentsForVehicleSubModel(@PathVariable Long categoryId, @PathVariable Long vehicleSubModelId) {
		return null;
	}

}
