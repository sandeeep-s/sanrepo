package com.eshop.vehicle.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleType;
import com.eshop.vehicle.service.VehicleMakeService;
import com.eshop.vehicle.service.VehicleModelService;
import com.eshop.vehicle.service.VehicleTypeService;

@Controller
@RequestMapping("/vehiclemodel")
public class VehicleModelController {

	@Inject
	private VehicleModelService vehicleModelService;

	@Inject
	private VehicleMakeService vehicleMakeService;

	@Inject
	private VehicleTypeService vehicleTypeService;

	public VehicleModelService getVehicleModelService() {
		return vehicleModelService;
	}

	public void setVehicleModelService(VehicleModelService vehicleModelService) {
		this.vehicleModelService = vehicleModelService;
	}

	public VehicleMakeService getVehicleMakeService() {
		return vehicleMakeService;
	}

	public void setVehicleMakeService(VehicleMakeService vehicleMakeService) {
		this.vehicleMakeService = vehicleMakeService;
	}

	public VehicleTypeService getVehicleTypeService() {
		return vehicleTypeService;
	}

	public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
		this.vehicleTypeService = vehicleTypeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllVehicleModels(Model model) {
		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);
		return "vehicleModelList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleModelForm(Model model) {
		model.addAttribute("vehicleModel", new VehicleModel());
		Set<VehicleMake> vehicleMakes = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakes);
		Set<VehicleType> vehicleTypes = vehicleTypeService.getAllVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypes);
		return "addVehicleModel";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleModelForm(@PathVariable Long id, Model model) {
		VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(id);
		model.addAttribute("vehicleModel", vehicleModel);
		Set<VehicleMake> vehicleMakes = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakes);
		Set<VehicleType> vehicleTypes = vehicleTypeService.getAllVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypes);
		return "editVehicleModel";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleModel(@Valid VehicleModel vehicleModel, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "addVehicleModel";
		}

		vehicleModelService.addVehicleModel(vehicleModel);

		model.addAttribute("vehicleModel", vehicleModel);
		return "addVehicleModelSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewVehicleModel(@PathVariable Long id, Model model) {
		VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(id);
		model.addAttribute(vehicleModel);
		return "viewVehicleModel";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleModel(@Valid VehicleModel vehicleModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "editVehicleModel";
		}
		return "editVehicleModelSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleModel(@PathVariable Long id) {
		vehicleModelService.deleteVehicleModel(id);
		return "deleteVehicleModelSuccess";
	}

}
