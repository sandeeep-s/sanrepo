package com.eshop.vehicle.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.common.model.Media;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.model.VehicleModel;
import com.eshop.vehicle.model.VehicleSubModel;
import com.eshop.vehicle.service.VehicleMakeService;
import com.eshop.vehicle.service.VehicleModelService;
import com.eshop.vehicle.service.VehicleSubModelService;

@Controller
@RequestMapping("/vehiclesubmodel")
public class VehicleSubModelController {

	@Inject
	private VehicleSubModelService vehicleSubModelService;

	@Inject
	private VehicleModelService vehicleModelService;

	@Inject
	@Named("vehicleMakeService")
	private VehicleMakeService vehicleMakeService;

	public VehicleSubModelService getVehicleSubModelService() {
		return vehicleSubModelService;
	}

	public void setVehicleSubModelService(VehicleSubModelService vehicleSubModelService) {
		this.vehicleSubModelService = vehicleSubModelService;
	}

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

	@RequestMapping(method = RequestMethod.GET)
	public String listAllVehicleSubModels(Model model) {
		Set<VehicleSubModel> vehicleSubModels = vehicleSubModelService.getAllVehicleSubModels();
		model.addAttribute("vehicleSubModels", vehicleSubModels);
		return "vehicleSubModelList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddVehicleSubModelForm(Model model) {
		VehicleSubModel vehicleSubModel = new VehicleSubModel();
		List<Media> images = new ArrayList<Media>();
		images.add(new Media());
		images.add(new Media());
		vehicleSubModel.setImages(images);
		model.addAttribute("vehicleSubModel", vehicleSubModel);
		
		Set<VehicleMake> vehicleMakes = vehicleMakeService.getAllVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakes);
		
		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);
		return "addVehicleSubModel";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditVehicleSubModelForm(@PathVariable Long id, Model model) {
		VehicleSubModel vehicleSubModel = vehicleSubModelService.getVehicleSubModelById(id);
		model.addAttribute("vehicleSubModel", vehicleSubModel);

		if (null == vehicleSubModel){
			model.addAttribute("vehicleSubModelId", id);
			return "vehicleSubModelNotFound";
		}

		Set<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);
		return "editVehicleSubModel";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addVehicleSubModel(@Valid VehicleSubModel vehicleSubModel, BindingResult bindingResult, Model model,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "addVehicleSubModel";
		}

		vehicleSubModelService.addVehicleSubModel(vehicleSubModel);

		model.addAttribute("vehicleSubModel", vehicleSubModel);
		return "addVehicleSubModelSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewVehicleSubModel(@PathVariable Long id, Model model) {
		VehicleSubModel vehicleSubModel = vehicleSubModelService.getVehicleSubModelById(id);
		if (null == vehicleSubModel){
			model.addAttribute("vehicleSubModelId", id);
			return "vehicleSubModelNotFound";
		}
		model.addAttribute("vehicleSubModel", vehicleSubModel);
		return "viewVehicleSubModel";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateVehicleSubModel(@Valid VehicleSubModel vehicleSubModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "editVehicleSubModel";
		}
		return "editVehicleSubModelSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteVehicleSubModel(@PathVariable Long id, Model model) {
		VehicleSubModel vehicleSubModel = vehicleSubModelService.deleteVehicleSubModel(id);
		model.addAttribute("vehicleSubModel", vehicleSubModel);
		return "deleteVehicleSubModelSuccess";
	}

}
